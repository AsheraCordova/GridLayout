// start - imports

export const enum AlignmentMode {
alignBounds = "alignBounds",
alignMargins = "alignMargins",
}
export const enum Orientation {
horizontal = "horizontal",
vertical = "vertical",
}	
import CommandAttr from '../../widget/CommandAttr';
import IWidget from '../../widget/IWidget';
import ILayoutParam from '../../widget/ILayoutParam';
import {plainToClass, Type, Exclude, Expose, Transform} from "class-transformer";
import 'babel-polyfill';
import {Gravity} from '../../widget/TypeConstants';
import {ITranform, TransformerFactory} from '../../widget/TransformerFactory';
import {Event} from '../../app/Event';
import {MotionEvent} from '../../app/MotionEvent';
import {DragEvent} from '../../app/DragEvent';
import {KeyEvent} from '../../app/KeyEvent';
import { ScopedObject } from '../../app/ScopedObject';















import {ViewGroupImpl_LayoutParams} from './ViewGroupImpl';

// end - imports
import {ViewGroupImpl} from './ViewGroupImpl';
export abstract class GridLayoutImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "alignmentMode" })
	alignmentMode!:CommandAttr<AlignmentMode>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "columnCount" })
	columnCount!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "columnOrderPreserved" })
	columnOrderPreserved!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "orientation" })
	orientation!:CommandAttr<Orientation>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "rowCount" })
	rowCount!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "rowOrderPreserved" })
	rowOrderPreserved!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "useDefaultMargins" })
	useDefaultMargins!:CommandAttr<boolean>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.alignmentMode = undefined;
		this.columnCount = undefined;
		this.columnOrderPreserved = undefined;
		this.orientation = undefined;
		this.rowCount = undefined;
		this.rowOrderPreserved = undefined;
		this.useDefaultMargins = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public tryGetAlignmentMode() : T {
		this.resetIfRequired();
		if (this.alignmentMode == null || this.alignmentMode == undefined) {
			this.alignmentMode = new CommandAttr<AlignmentMode>()
		}
		
		this.alignmentMode.setGetter(true);
		this.orderGet++;
		this.alignmentMode.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getAlignmentMode() : AlignmentMode {
		if (this.alignmentMode == null || this.alignmentMode == undefined) {
			this.alignmentMode = new CommandAttr<AlignmentMode>();
		}
		return this.alignmentMode.getCommandReturnValue();
	}
	public setAlignmentMode(value : AlignmentMode) : T {
		this.resetIfRequired();
		if (this.alignmentMode == null || this.alignmentMode == undefined) {
			this.alignmentMode = new CommandAttr<AlignmentMode>();
		}
		
		this.alignmentMode.setSetter(true);
		this.alignmentMode.setValue(value);
		this.orderSet++;
		this.alignmentMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetColumnCount() : T {
		this.resetIfRequired();
		if (this.columnCount == null || this.columnCount == undefined) {
			this.columnCount = new CommandAttr<number>()
		}
		
		this.columnCount.setGetter(true);
		this.orderGet++;
		this.columnCount.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getColumnCount() : number {
		if (this.columnCount == null || this.columnCount == undefined) {
			this.columnCount = new CommandAttr<number>();
		}
		return this.columnCount.getCommandReturnValue();
	}
	public setColumnCount(value : number) : T {
		this.resetIfRequired();
		if (this.columnCount == null || this.columnCount == undefined) {
			this.columnCount = new CommandAttr<number>();
		}
		
		this.columnCount.setSetter(true);
		this.columnCount.setValue(value);
		this.orderSet++;
		this.columnCount.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetColumnOrderPreserved() : T {
		this.resetIfRequired();
		if (this.columnOrderPreserved == null || this.columnOrderPreserved == undefined) {
			this.columnOrderPreserved = new CommandAttr<boolean>()
		}
		
		this.columnOrderPreserved.setGetter(true);
		this.orderGet++;
		this.columnOrderPreserved.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isColumnOrderPreserved() : boolean {
		if (this.columnOrderPreserved == null || this.columnOrderPreserved == undefined) {
			this.columnOrderPreserved = new CommandAttr<boolean>();
		}
		return this.columnOrderPreserved.getCommandReturnValue();
	}
	public setColumnOrderPreserved(value : boolean) : T {
		this.resetIfRequired();
		if (this.columnOrderPreserved == null || this.columnOrderPreserved == undefined) {
			this.columnOrderPreserved = new CommandAttr<boolean>();
		}
		
		this.columnOrderPreserved.setSetter(true);
		this.columnOrderPreserved.setValue(value);
		this.orderSet++;
		this.columnOrderPreserved.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetOrientation() : T {
		this.resetIfRequired();
		if (this.orientation == null || this.orientation == undefined) {
			this.orientation = new CommandAttr<Orientation>()
		}
		
		this.orientation.setGetter(true);
		this.orderGet++;
		this.orientation.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getOrientation() : Orientation {
		if (this.orientation == null || this.orientation == undefined) {
			this.orientation = new CommandAttr<Orientation>();
		}
		return this.orientation.getCommandReturnValue();
	}
	public setOrientation(value : Orientation) : T {
		this.resetIfRequired();
		if (this.orientation == null || this.orientation == undefined) {
			this.orientation = new CommandAttr<Orientation>();
		}
		
		this.orientation.setSetter(true);
		this.orientation.setValue(value);
		this.orderSet++;
		this.orientation.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetRowCount() : T {
		this.resetIfRequired();
		if (this.rowCount == null || this.rowCount == undefined) {
			this.rowCount = new CommandAttr<number>()
		}
		
		this.rowCount.setGetter(true);
		this.orderGet++;
		this.rowCount.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getRowCount() : number {
		if (this.rowCount == null || this.rowCount == undefined) {
			this.rowCount = new CommandAttr<number>();
		}
		return this.rowCount.getCommandReturnValue();
	}
	public setRowCount(value : number) : T {
		this.resetIfRequired();
		if (this.rowCount == null || this.rowCount == undefined) {
			this.rowCount = new CommandAttr<number>();
		}
		
		this.rowCount.setSetter(true);
		this.rowCount.setValue(value);
		this.orderSet++;
		this.rowCount.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetRowOrderPreserved() : T {
		this.resetIfRequired();
		if (this.rowOrderPreserved == null || this.rowOrderPreserved == undefined) {
			this.rowOrderPreserved = new CommandAttr<boolean>()
		}
		
		this.rowOrderPreserved.setGetter(true);
		this.orderGet++;
		this.rowOrderPreserved.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isRowOrderPreserved() : boolean {
		if (this.rowOrderPreserved == null || this.rowOrderPreserved == undefined) {
			this.rowOrderPreserved = new CommandAttr<boolean>();
		}
		return this.rowOrderPreserved.getCommandReturnValue();
	}
	public setRowOrderPreserved(value : boolean) : T {
		this.resetIfRequired();
		if (this.rowOrderPreserved == null || this.rowOrderPreserved == undefined) {
			this.rowOrderPreserved = new CommandAttr<boolean>();
		}
		
		this.rowOrderPreserved.setSetter(true);
		this.rowOrderPreserved.setValue(value);
		this.orderSet++;
		this.rowOrderPreserved.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetUseDefaultMargins() : T {
		this.resetIfRequired();
		if (this.useDefaultMargins == null || this.useDefaultMargins == undefined) {
			this.useDefaultMargins = new CommandAttr<boolean>()
		}
		
		this.useDefaultMargins.setGetter(true);
		this.orderGet++;
		this.useDefaultMargins.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isUseDefaultMargins() : boolean {
		if (this.useDefaultMargins == null || this.useDefaultMargins == undefined) {
			this.useDefaultMargins = new CommandAttr<boolean>();
		}
		return this.useDefaultMargins.getCommandReturnValue();
	}
	public setUseDefaultMargins(value : boolean) : T {
		this.resetIfRequired();
		if (this.useDefaultMargins == null || this.useDefaultMargins == undefined) {
			this.useDefaultMargins = new CommandAttr<boolean>();
		}
		
		this.useDefaultMargins.setSetter(true);
		this.useDefaultMargins.setValue(value);
		this.orderSet++;
		this.useDefaultMargins.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
//start - staticinit
export abstract class GridLayoutImpl_LayoutParams<T> extends ViewGroupImpl_LayoutParams<T> {
	@Type(() => CommandAttr)
	@Expose({ name: "layout_column" })
	layout_column!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_columnSpan" })
	layout_columnSpan!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_columnWeight" })
	layout_columnWeight!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_row" })
	layout_row!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_rowSpan" })
	layout_rowSpan!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_rowWeight" })
	layout_rowWeight!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout_gravity" })
	layout_gravity!:CommandAttr<Gravity[]>| undefined;
	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.layout_column = undefined;
		this.layout_columnSpan = undefined;
		this.layout_columnWeight = undefined;
		this.layout_row = undefined;
		this.layout_rowSpan = undefined;
		this.layout_rowWeight = undefined;
		this.layout_gravity = undefined;
		return this.thisPointer;
	}
	constructor() {
		super();
		this.thisPointer = this.getThisPointer();
	}
	
	public setLayoutColumn(value : number) : T {
		if (this.layout_column == null || this.layout_column == undefined) {
			this.layout_column = new CommandAttr<number>();
		}
		this.layout_column.setSetter(true);
		this.layout_column.setValue(value);
		this.orderSet++;
		this.layout_column.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public setLayoutColumnSpan(value : number) : T {
		if (this.layout_columnSpan == null || this.layout_columnSpan == undefined) {
			this.layout_columnSpan = new CommandAttr<number>();
		}
		this.layout_columnSpan.setSetter(true);
		this.layout_columnSpan.setValue(value);
		this.orderSet++;
		this.layout_columnSpan.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public setLayoutColumnWeight(value : number) : T {
		if (this.layout_columnWeight == null || this.layout_columnWeight == undefined) {
			this.layout_columnWeight = new CommandAttr<number>();
		}
		this.layout_columnWeight.setSetter(true);
		this.layout_columnWeight.setValue(value);
		this.orderSet++;
		this.layout_columnWeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public setLayoutRow(value : number) : T {
		if (this.layout_row == null || this.layout_row == undefined) {
			this.layout_row = new CommandAttr<number>();
		}
		this.layout_row.setSetter(true);
		this.layout_row.setValue(value);
		this.orderSet++;
		this.layout_row.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public setLayoutRowSpan(value : number) : T {
		if (this.layout_rowSpan == null || this.layout_rowSpan == undefined) {
			this.layout_rowSpan = new CommandAttr<number>();
		}
		this.layout_rowSpan.setSetter(true);
		this.layout_rowSpan.setValue(value);
		this.orderSet++;
		this.layout_rowSpan.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public setLayoutRowWeight(value : number) : T {
		if (this.layout_rowWeight == null || this.layout_rowWeight == undefined) {
			this.layout_rowWeight = new CommandAttr<number>();
		}
		this.layout_rowWeight.setSetter(true);
		this.layout_rowWeight.setValue(value);
		this.orderSet++;
		this.layout_rowWeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
	public setLayoutGravity(...value : Gravity[]) : T {
		if (this.layout_gravity == null || this.layout_gravity == undefined) {
			this.layout_gravity = new CommandAttr<Gravity[]>();
		}
		this.layout_gravity.setSetter(true);
		this.layout_gravity.setValue(value);
		this.orderSet++;
		this.layout_gravity.setOrderSet(this.orderSet);
this.layout_gravity.setTransformer('gravity');		return this.thisPointer;
	}
}

export class GridLayout_LayoutParams extends GridLayoutImpl_LayoutParams<GridLayout_LayoutParams> implements ILayoutParam {
    getThisPointer(): GridLayout_LayoutParams {
        return this;
    }

   	constructor() {
		super();	
	}
}

export class GridLayout extends GridLayoutImpl<GridLayout> implements IWidget{
    getThisPointer(): GridLayout {
        return this;
    }
    
   	public getClass() {
		return GridLayout;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

GridLayoutImpl.initialize();

//end - staticinit
