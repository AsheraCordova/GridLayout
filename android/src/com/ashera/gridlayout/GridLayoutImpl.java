package com.ashera.gridlayout;
// start - imports
import java.util.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.*;
import android.widget.*;
import android.view.View.*;

import com.ashera.widget.BaseHasWidgets;

import android.annotation.SuppressLint;

import com.ashera.core.IFragment;
import com.ashera.widget.bus.*;
import com.ashera.converter.*;
import com.ashera.widget.bus.Event.*;
import com.ashera.widget.*;
import com.ashera.widget.IWidgetLifeCycleListener.*;
import com.ashera.layout.*;

import android.graphics.Canvas;
import android.widget.*;
import androidx.core.view.*;
import android.view.*;

import static com.ashera.widget.IWidget.*;
//end - imports

import static android.view.Gravity.*;

@SuppressLint("NewApi")
public class GridLayoutImpl extends BaseHasWidgets {
	//start - body
	public final static String LOCAL_NAME = "androidx.gridlayout.widget.GridLayout"; 
	public final static String GROUP_NAME = "GridLayout";
	private androidx.gridlayout.widget.GridLayout gridLayout;
	

	
		@SuppressLint("NewApi")
		final static class AlignmentMode extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("alignBounds",  0x0);
				mapping.put("alignMargins",  0x1);
				}
		@Override
		public Map<String, Integer> getMapping() {
				return mapping;
				}

		@Override
		public Integer getDefault() {
				return 0;
				}
				}
		@SuppressLint("NewApi")
		final static class Orientation extends AbstractEnumToIntConverter{
		private Map<String, Integer> mapping = new HashMap<>();
				{
				mapping.put("horizontal",  0x0);
				mapping.put("vertical",  0x1);
				}
		@Override
		public Map<String, Integer> getMapping() {
				return mapping;
				}

		@Override
		public Integer getDefault() {
				return 0;
				}
				}
	@Override
	public void loadAttributes(String localName) {
		ViewGroupImpl.register(localName);

		ConverterFactory.register("androidx.gridlayout.widget.GridLayout.alignmentMode", new AlignmentMode());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("alignmentMode").withType("androidx.gridlayout.widget.GridLayout.alignmentMode"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("columnCount").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("columnOrderPreserved").withType("boolean"));
		ConverterFactory.register("androidx.gridlayout.widget.GridLayout.orientation", new Orientation());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("orientation").withType("androidx.gridlayout.widget.GridLayout.orientation"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("rowCount").withType("int"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("rowOrderPreserved").withType("boolean"));
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("useDefaultMargins").withType("boolean"));
	
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_column").withType("int").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_columnSpan").withType("int").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_columnWeight").withType("int").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_row").withType("int").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_rowSpan").withType("int").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_rowWeight").withType("int").forChild());
		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("layout_gravity").withType("gravity").forChild());
	}
	
	public GridLayoutImpl() {
		super(GROUP_NAME, LOCAL_NAME);
	}
	public  GridLayoutImpl(String localname) {
		super(GROUP_NAME, localname);
	}
	public  GridLayoutImpl(String groupName, String localname) {
		super(groupName, localname);
	}

	@Override
	public IWidget newInstance() {
		return new GridLayoutImpl();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void create(IFragment fragment, Map<String, Object> params) {
		super.create(fragment, params);
Context context = (Context) fragment.getRootActivity();
	Object systemStyle = params.get("systemStyle");
	Object systemAndroidAttrStyle = params.get("systemAndroidAttrStyle");
	
	if (systemStyle == null && systemAndroidAttrStyle == null) {
		gridLayout = new GridLayoutExt(context);
	} else {
		int defStyleAttr = 0;
		int defStyleRes = 0;
		
		if (systemStyle != null) {
			defStyleRes = context.getResources().getIdentifier((String) systemStyle, "style", context.getPackageName());	
		}
		
		if (systemAndroidAttrStyle != null) {
			defStyleAttr = context.getResources().getIdentifier((String) systemAndroidAttrStyle, "attr", "android");	
		}
		
		if (defStyleRes == 0) {
			gridLayout = new GridLayoutExt(context, null, defStyleAttr);	
		} else {
		}
		
	}

		
		nativeCreate(params);
		
		
		ViewGroupImpl.registerCommandConveter(this);
	}

	@Override
	public Object asWidget() {
		return gridLayout;
	}

	@Override
	public boolean remove(IWidget w) {
		boolean remove = super.remove(w);
		gridLayout.removeView((View) w.asWidget());
		return remove;
	}
	
	@Override
    public boolean remove(int index) {
		IWidget widget = widgets.get(index);
        boolean remove = super.remove(index);

        if (index + 1 <= gridLayout.getChildCount()) {
            gridLayout.removeViewAt(index);
        }    
        return remove;
    }
	
	@Override
	public void add(IWidget w, int index) {
		if (index != -2) {
			View view = (View) w.asWidget();
			createLayoutParams(view);
			    if (index == -1) {
			        gridLayout.addView(view);
			    } else {
			        gridLayout.addView(view, index);
			    }
		}
		
		ViewGroupImpl.nativeAddView(asNativeWidget(), w.asNativeWidget());
		super.add(w, index);
	}
	
	private void createLayoutParams(View view) {
		androidx.gridlayout.widget.GridLayout.LayoutParams layoutParams = (androidx.gridlayout.widget.GridLayout.LayoutParams) view.getLayoutParams();
		
		layoutParams = (androidx.gridlayout.widget.GridLayout.LayoutParams) view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new androidx.gridlayout.widget.GridLayout.LayoutParams();
			view.setLayoutParams(layoutParams);
		}  else {
			layoutParams.height = -2;
			layoutParams.width = -2;
		}
	}
	
	private androidx.gridlayout.widget.GridLayout.LayoutParams getLayoutParams(View view) {
		return (androidx.gridlayout.widget.GridLayout.LayoutParams) view.getLayoutParams();		
	}
	
	@SuppressLint("NewApi")
	@Override
	public void setChildAttribute(IWidget w, WidgetAttribute key, String strValue, Object objValue) {
		View view = (View) w.asWidget();
		androidx.gridlayout.widget.GridLayout.LayoutParams layoutParams = getLayoutParams(view);
		ViewGroupImpl.setChildAttribute(w, key, objValue, layoutParams);		
		
		switch (key.getAttributeName()) {
		case "layout_width":
			layoutParams.width = (int) objValue;
			break;	
		case "layout_height":
			layoutParams.height = (int) objValue;
			break;
			case "layout_column": {
				
							layoutParams.columnSpec = getSpec(w, w.getAttributes(), "column");
				
			}
			break;
			case "layout_columnSpan": {
				
							layoutParams.columnSpec = getSpec(w, w.getAttributes(), "column");
				
			}
			break;
			case "layout_columnWeight": {
				
							layoutParams.columnSpec = getSpec(w, w.getAttributes(), "column");
				
			}
			break;
			case "layout_row": {
				
							layoutParams.rowSpec = getSpec(w, w.getAttributes(), "row");
				
			}
			break;
			case "layout_rowSpan": {
				
							layoutParams.rowSpec = getSpec(w, w.getAttributes(), "row");
				
			}
			break;
			case "layout_rowWeight": {
				
							layoutParams.rowSpec = getSpec(w, w.getAttributes(), "row");
				
			}
			break;
			case "layout_gravity": {
				
							layoutParams.columnSpec = getSpec(w, w.getAttributes(), "column");layoutParams.rowSpec = getSpec(w, w.getAttributes(), "row");
				
			}
			break;
		default:
			break;
		}
		
		
		view.setLayoutParams(layoutParams);		
	}
	
	@SuppressLint("NewApi")
	@Override
	public Object getChildAttribute(IWidget w, WidgetAttribute key) {
		Object attributeValue = ViewGroupImpl.getChildAttribute(w, key);		
		if (attributeValue != null) {
			return attributeValue;
		}
		View view = (View) w.asWidget();
		androidx.gridlayout.widget.GridLayout.LayoutParams layoutParams = getLayoutParams(view);

		switch (key.getAttributeName()) {
		case "layout_width":
			return layoutParams.width;
		case "layout_height":
			return layoutParams.height;







		}
		
		return null;

	}
	
		
	public class GridLayoutExt extends androidx.gridlayout.widget.GridLayout implements ILifeCycleDecorator, com.ashera.widget.IMaxDimension{
		private MeasureEvent measureFinished = new MeasureEvent();
		private OnLayoutEvent onLayoutEvent = new OnLayoutEvent();
		private int mMaxWidth = -1;
		private int mMaxHeight = -1;
		@Override
		public void setMaxWidth(int width) {
			mMaxWidth = width;
		}
		@Override
		public void setMaxHeight(int height) {
			mMaxHeight = height;
		}
		@Override
		public int getMaxWidth() {
			return mMaxWidth;
		}
		@Override
		public int getMaxHeight() {
			return mMaxHeight;
		}

		public GridLayoutExt(Context context, android.util.AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	    }

		public GridLayoutExt(Context context) {
			super(context);
			
			
			
			
			
			
		}
		
		@Override
		public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

			if(mMaxWidth > 0) {
	        	widthMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxWidth, MeasureSpec.AT_MOST);
	        }
	        if(mMaxHeight > 0) {
	            heightMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxHeight, MeasureSpec.AT_MOST);

	        }

	        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			IWidgetLifeCycleListener listener = (IWidgetLifeCycleListener) getListener();
			if (listener != null) {
			    measureFinished.setWidth(getMeasuredWidth());
			    measureFinished.setHeight(getMeasuredHeight());
				listener.eventOccurred(EventId.measureFinished, measureFinished);
			}
		}
		
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			super.onLayout(changed, l, t, r, b);
			ViewImpl.nativeMakeFrame(asNativeWidget(), l, t, r, b);
			replayBufferedEvents();
			
			IWidgetLifeCycleListener listener = (IWidgetLifeCycleListener) getListener();
			if (listener != null) {
				onLayoutEvent.setB(b);
				onLayoutEvent.setL(l);
				onLayoutEvent.setR(r);
				onLayoutEvent.setT(t);
				onLayoutEvent.setChanged(changed);
				listener.eventOccurred(EventId.onLayout, onLayoutEvent);
			}
			
			if (isInvalidateOnFrameChange() && isInitialised()) {
				GridLayoutImpl.this.invalidate();
			}
		}	
		
		@Override
		public void onDraw(Canvas canvas) {
			Runnable runnable = () -> super.onDraw(canvas);
			executeMethodListeners("onDraw", runnable, canvas);
		}

		@Override
		public void draw(Canvas canvas) {
			Runnable runnable = () -> super.draw(canvas);
			executeMethodListeners("draw", runnable, canvas);
		}

		@SuppressLint("WrongCall")
		@Override
		public void execute(String method, Object... args) {
			switch (method) {
				case "onDraw":
					setOnMethodCalled(true);
					super.onDraw((Canvas) args[0]);
					break;

				case "draw":
					setOnMethodCalled(true);
					super.draw((Canvas) args[0]);
					break;

				default:
					break;
			}
		}

		public void updateMeasuredDimension(int width, int height) {
			setMeasuredDimension(width, height);
		}


		@Override
		public ILifeCycleDecorator newInstance(IWidget widget) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setAttribute(WidgetAttribute widgetAttribute,
				String strValue, Object objValue) {
			throw new UnsupportedOperationException();
		}		
		

		@Override
		public List<String> getMethods() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public void initialized() {
			throw new UnsupportedOperationException();
		}
		
        @Override
        public Object getAttribute(WidgetAttribute widgetAttribute) {
            throw new UnsupportedOperationException();
        }
        @Override
        public void drawableStateChanged() {
        	super.drawableStateChanged();
        	ViewImpl.drawableStateChanged(GridLayoutImpl.this);
        }
	}
	
	public void updateMeasuredDimension(int width, int height) {
		((GridLayoutExt) gridLayout).updateMeasuredDimension(width, height);
	}
	

	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		ViewGroupImpl.setAttribute(this, key, strValue, objValue, decorator);
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "alignmentMode": {
if (Build.VERSION.SDK_INT >= 14) {

	gridLayout.setAlignmentMode((int)objValue);

}

			}
			break;
			case "columnCount": {
if (Build.VERSION.SDK_INT >= 14) {

	gridLayout.setColumnCount((int)objValue);

}

			}
			break;
			case "columnOrderPreserved": {
if (Build.VERSION.SDK_INT >= 14) {

	gridLayout.setColumnOrderPreserved((boolean)objValue);

}

			}
			break;
			case "orientation": {
if (Build.VERSION.SDK_INT >= 14) {

	gridLayout.setOrientation((int)objValue);

}

			}
			break;
			case "rowCount": {
if (Build.VERSION.SDK_INT >= 14) {

	gridLayout.setRowCount((int)objValue);

}

			}
			break;
			case "rowOrderPreserved": {
if (Build.VERSION.SDK_INT >= 14) {

	gridLayout.setRowOrderPreserved((boolean)objValue);

}

			}
			break;
			case "useDefaultMargins": {
if (Build.VERSION.SDK_INT >= 14) {

	gridLayout.setUseDefaultMargins((boolean)objValue);

}

			}
			break;
		default:
			break;
		}
		
	}
	
	@Override
	@SuppressLint("NewApi")
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		Object attributeValue = ViewGroupImpl.getAttribute(this, key, decorator);
		if (attributeValue != null) {
			return attributeValue;
		}
		Object nativeWidget = asNativeWidget();
		switch (key.getAttributeName()) {
			case "alignmentMode": {
if (Build.VERSION.SDK_INT >= 14) {
return gridLayout.getAlignmentMode();
}
break;			}
			case "columnCount": {
if (Build.VERSION.SDK_INT >= 14) {
return gridLayout.getColumnCount();
}
break;			}
			case "columnOrderPreserved": {
if (Build.VERSION.SDK_INT >= 14) {
return gridLayout.isColumnOrderPreserved();
}
break;			}
			case "orientation": {
if (Build.VERSION.SDK_INT >= 14) {
return gridLayout.getOrientation();
}
break;			}
			case "rowCount": {
if (Build.VERSION.SDK_INT >= 14) {
return gridLayout.getRowCount();
}
break;			}
			case "rowOrderPreserved": {
if (Build.VERSION.SDK_INT >= 14) {
return gridLayout.isRowOrderPreserved();
}
break;			}
			case "useDefaultMargins": {
if (Build.VERSION.SDK_INT >= 14) {
return gridLayout.getUseDefaultMargins();
}
break;			}
		}
		return null;
	}


	@Override
    public Object asNativeWidget() {
        return gridLayout;
    }
    private void nativeCreate(Map<String, Object> params) {
    }
    
    @Override
    public void requestLayout() {
    	if (isInitialised()) {
    		ViewImpl.requestLayout(this, asNativeWidget());
    	}
    }
    
    @Override
    public void invalidate() {
    	if (isInitialised()) {
    		ViewImpl.invalidate(this, asNativeWidget());
    	}
    }
    
	

	@Override
	public void setId(String id){
		if (id != null && !id.equals("")){
			super.setId(id);
			gridLayout.setId(IdGenerator.getId(id));
		}
	}
	
    

	
private GridLayoutCommandBuilder builder;
private GridLayoutBean bean;
public Object getPlugin(String plugin) {
	return WidgetFactory.getAttributable(plugin).newInstance(this);
}
public GridLayoutBean getBean() {
	if (bean == null) {
		bean = new GridLayoutBean();
	}
	return bean;
}
public GridLayoutCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new GridLayoutCommandBuilder();
	}
	return builder;
}


public  class GridLayoutCommandBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandBuilder <GridLayoutCommandBuilder> {
    public GridLayoutCommandBuilder() {
	}
	
	public GridLayoutCommandBuilder execute(boolean setter) {
		if (setter) {
			executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			getFragment().remeasure();
		}
		executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public GridLayoutCommandBuilder tryGetAlignmentMode() {
	Map<String, Object> attrs = initCommand("alignmentMode");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getAlignmentMode() {
	Map<String, Object> attrs = initCommand("alignmentMode");
	return attrs.get("commandReturnValue");
}
public GridLayoutCommandBuilder setAlignmentMode(String value) {
	Map<String, Object> attrs = initCommand("alignmentMode");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public GridLayoutCommandBuilder tryGetColumnCount() {
	Map<String, Object> attrs = initCommand("columnCount");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getColumnCount() {
	Map<String, Object> attrs = initCommand("columnCount");
	return attrs.get("commandReturnValue");
}
public GridLayoutCommandBuilder setColumnCount(int value) {
	Map<String, Object> attrs = initCommand("columnCount");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public GridLayoutCommandBuilder tryGetColumnOrderPreserved() {
	Map<String, Object> attrs = initCommand("columnOrderPreserved");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isColumnOrderPreserved() {
	Map<String, Object> attrs = initCommand("columnOrderPreserved");
	return attrs.get("commandReturnValue");
}
public GridLayoutCommandBuilder setColumnOrderPreserved(boolean value) {
	Map<String, Object> attrs = initCommand("columnOrderPreserved");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public GridLayoutCommandBuilder tryGetOrientation() {
	Map<String, Object> attrs = initCommand("orientation");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getOrientation() {
	Map<String, Object> attrs = initCommand("orientation");
	return attrs.get("commandReturnValue");
}
public GridLayoutCommandBuilder setOrientation(String value) {
	Map<String, Object> attrs = initCommand("orientation");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public GridLayoutCommandBuilder tryGetRowCount() {
	Map<String, Object> attrs = initCommand("rowCount");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object getRowCount() {
	Map<String, Object> attrs = initCommand("rowCount");
	return attrs.get("commandReturnValue");
}
public GridLayoutCommandBuilder setRowCount(int value) {
	Map<String, Object> attrs = initCommand("rowCount");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public GridLayoutCommandBuilder tryGetRowOrderPreserved() {
	Map<String, Object> attrs = initCommand("rowOrderPreserved");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isRowOrderPreserved() {
	Map<String, Object> attrs = initCommand("rowOrderPreserved");
	return attrs.get("commandReturnValue");
}
public GridLayoutCommandBuilder setRowOrderPreserved(boolean value) {
	Map<String, Object> attrs = initCommand("rowOrderPreserved");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public GridLayoutCommandBuilder tryGetUseDefaultMargins() {
	Map<String, Object> attrs = initCommand("useDefaultMargins");
	attrs.put("type", "attribute");
	attrs.put("getter", true);
	attrs.put("orderGet", ++orderGet);
return this;}

public Object isUseDefaultMargins() {
	Map<String, Object> attrs = initCommand("useDefaultMargins");
	return attrs.get("commandReturnValue");
}
public GridLayoutCommandBuilder setUseDefaultMargins(boolean value) {
	Map<String, Object> attrs = initCommand("useDefaultMargins");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class GridLayoutBean extends com.ashera.layout.ViewGroupImpl.ViewGroupBean{
		public GridLayoutBean() {
			super(GridLayoutImpl.this);
		}
public Object getAlignmentMode() {
	return getBuilder().reset().tryGetAlignmentMode().execute(false).getAlignmentMode(); 
}
public void setAlignmentMode(String value) {
	getBuilder().reset().setAlignmentMode(value).execute(true);
}

public Object getColumnCount() {
	return getBuilder().reset().tryGetColumnCount().execute(false).getColumnCount(); 
}
public void setColumnCount(int value) {
	getBuilder().reset().setColumnCount(value).execute(true);
}

public Object isColumnOrderPreserved() {
	return getBuilder().reset().tryGetColumnOrderPreserved().execute(false).isColumnOrderPreserved(); 
}
public void setColumnOrderPreserved(boolean value) {
	getBuilder().reset().setColumnOrderPreserved(value).execute(true);
}

public Object getOrientation() {
	return getBuilder().reset().tryGetOrientation().execute(false).getOrientation(); 
}
public void setOrientation(String value) {
	getBuilder().reset().setOrientation(value).execute(true);
}

public Object getRowCount() {
	return getBuilder().reset().tryGetRowCount().execute(false).getRowCount(); 
}
public void setRowCount(int value) {
	getBuilder().reset().setRowCount(value).execute(true);
}

public Object isRowOrderPreserved() {
	return getBuilder().reset().tryGetRowOrderPreserved().execute(false).isRowOrderPreserved(); 
}
public void setRowOrderPreserved(boolean value) {
	getBuilder().reset().setRowOrderPreserved(value).execute(true);
}

public Object isUseDefaultMargins() {
	return getBuilder().reset().tryGetUseDefaultMargins().execute(false).isUseDefaultMargins(); 
}
public void setUseDefaultMargins(boolean value) {
	getBuilder().reset().setUseDefaultMargins(value).execute(true);
}

}


private GridLayoutCommandParamsBuilder paramsBuilder;
private GridLayoutParamsBean paramsBean;

public GridLayoutParamsBean getParamsBean() {
	if (paramsBean == null) {
		paramsBean = new GridLayoutParamsBean();
	}
	return paramsBean;
}
public GridLayoutCommandParamsBuilder getParamsBuilder() {
	if (paramsBuilder == null) {
		paramsBuilder = new GridLayoutCommandParamsBuilder();
	}
	return paramsBuilder;
}



public class GridLayoutParamsBean extends com.ashera.layout.ViewGroupImpl.ViewGroupParamsBean{
public void setLayoutColumn(IWidget w, int value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutColumn(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public void setLayoutColumnSpan(IWidget w, int value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutColumnSpan(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public void setLayoutColumnWeight(IWidget w, int value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutColumnWeight(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public void setLayoutRow(IWidget w, int value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutRow(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public void setLayoutRowSpan(IWidget w, int value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutRowSpan(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public void setLayoutRowWeight(IWidget w, int value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutRowWeight(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

public void setLayoutGravity(IWidget w, String value) {
	java.util.Map<String, Object> layoutParams = new java.util.HashMap<String, Object>();
	layoutParams.put("layoutParams", getParamsBuilder().reset().setLayoutGravity(value).getCommand());
	w.executeCommand(layoutParams, null, COMMAND_EXEC_SETTER_METHOD);
	w.getFragment().remeasure();
}

}





public class GridLayoutCommandParamsBuilder extends com.ashera.layout.ViewGroupImpl.ViewGroupCommandParamsBuilder<GridLayoutCommandParamsBuilder>{
public GridLayoutCommandParamsBuilder setLayoutColumn(int value) {
	Map<String, Object> attrs = initCommand("layout_column");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public GridLayoutCommandParamsBuilder setLayoutColumnSpan(int value) {
	Map<String, Object> attrs = initCommand("layout_columnSpan");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public GridLayoutCommandParamsBuilder setLayoutColumnWeight(int value) {
	Map<String, Object> attrs = initCommand("layout_columnWeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public GridLayoutCommandParamsBuilder setLayoutRow(int value) {
	Map<String, Object> attrs = initCommand("layout_row");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public GridLayoutCommandParamsBuilder setLayoutRowSpan(int value) {
	Map<String, Object> attrs = initCommand("layout_rowSpan");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public GridLayoutCommandParamsBuilder setLayoutRowWeight(int value) {
	Map<String, Object> attrs = initCommand("layout_rowWeight");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
public GridLayoutCommandParamsBuilder setLayoutGravity(String value) {
	Map<String, Object> attrs = initCommand("layout_gravity");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}

	//end - body
    //start - codecopy
	public androidx.gridlayout.widget.GridLayout.Spec getSpec(String str) {
		androidx.gridlayout.widget.GridLayout.Spec spec = null;
		if (str != null) {
			java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\s*,\\s*");
			String[] columnDefs = pattern.split(str);

			if (columnDefs.length == 1) {
				spec = androidx.gridlayout.widget.GridLayout.spec(convertStringToint(columnDefs[0]), 1, 1);
			} else if (columnDefs.length == 2) {
				spec = androidx.gridlayout.widget.GridLayout.spec(convertStringToint(columnDefs[0]),
						convertStringToint(columnDefs[1]), 0);
			} else if (columnDefs.length == 3) {
				spec = androidx.gridlayout.widget.GridLayout.spec(convertStringToint(columnDefs[0]),
						convertStringToint(columnDefs[1]),
						convertStringToint(columnDefs[2]));
			}
		}

		return spec;
	}

	public int convertStringToint(String str) {
		try {
			return Integer.valueOf(str);
		} catch (Exception e) {
			return 0;
		}
	}

	public static final int UNDEFINED = Integer.MIN_VALUE;
	public static final int DEFAULT_COLUMN = Integer.MIN_VALUE;
	public static final int DEFAULT_SPAN_SIZE = 1;
	public static final float DEFAULT_WEIGHT = 0;
	public static final int DEFAULT_GRAVITY = Gravity.NO_GRAVITY;

	public androidx.gridlayout.widget.GridLayout.Spec getSpec(IWidget w, WidgetAttributeMap attributes, String columnRow) {
		androidx.gridlayout.widget.GridLayout.Spec spec = null;
		int column	=  DEFAULT_COLUMN;
		int colSpan = DEFAULT_SPAN_SIZE;
		float colWeight = DEFAULT_WEIGHT;
		int gravity	=  DEFAULT_GRAVITY;

		if (attributes.containsKey("layout_" + columnRow)) {
			column = (Integer) ConverterFactory.get("int").convertFrom(w.getAttributeValue("layout_" + columnRow), null, fragment);
		}
		if (attributes.containsKey("layout_"+ columnRow + "Span")) {
			colSpan = (Integer) ConverterFactory.get("int").convertFrom(w.getAttributeValue("layout_" + columnRow
					+ "Span"), null, fragment);
		}
		if (attributes.containsKey("layout_" + columnRow + "Weight")) {
			colWeight = (Float) ConverterFactory.get("float").convertFrom(w.getAttributeValue("layout_" + columnRow
					+ "Weight"), null, fragment);
		}
		if (attributes.containsKey("layout_gravity")) {
			gravity = (Integer) ConverterFactory.get("gravity").convertFrom(w.getAttributeValue("layout_gravity"), null, fragment);
		}

		spec = androidx.gridlayout.widget.GridLayout.spec(column, colSpan, getAlignment(gravity, columnRow.equals("column")), colWeight);
		return spec;
	}

	androidx.gridlayout.widget.GridLayout.Alignment getAlignment(int gravity, boolean horizontal) {
		int mask = horizontal ? HORIZONTAL_GRAVITY_MASK : VERTICAL_GRAVITY_MASK;
		int shift = horizontal ? AXIS_X_SHIFT : AXIS_Y_SHIFT;
		int flags = (gravity & mask) >> shift;
		switch (flags) {
			case (AXIS_SPECIFIED | AXIS_PULL_BEFORE):
				return horizontal ? androidx.gridlayout.widget.GridLayout.LEFT : androidx.gridlayout.widget.GridLayout.TOP;
			case (AXIS_SPECIFIED | AXIS_PULL_AFTER):
				return horizontal ? androidx.gridlayout.widget.GridLayout.RIGHT : androidx.gridlayout.widget.GridLayout.BOTTOM;
			case (AXIS_SPECIFIED | AXIS_PULL_BEFORE | AXIS_PULL_AFTER):
				return androidx.gridlayout.widget.GridLayout.FILL;
			case AXIS_SPECIFIED:
				return androidx.gridlayout.widget.GridLayout.CENTER;
			case (AXIS_SPECIFIED | AXIS_PULL_BEFORE | RELATIVE_LAYOUT_DIRECTION):
				return androidx.gridlayout.widget.GridLayout.START;
			case (AXIS_SPECIFIED | AXIS_PULL_AFTER | RELATIVE_LAYOUT_DIRECTION):
				return androidx.gridlayout.widget.GridLayout.END;
			default:
				return androidx.gridlayout.widget.GridLayout.TOP;
		}
	}
	//end - codecopy
}
