package commands;

import main.ResponseContext;

public class uploadCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		resc.setTarget("uploadwidget");
		return resc;
	}
}