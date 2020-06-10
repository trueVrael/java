package zad1;

import java.text.DecimalFormat;
import javax.swing.AbstractListModel;

public class TempModel extends AbstractListModel {

	@Override
	public int getSize() {
		return 131;
	}

	@Override
	public String getElementAt(int index) {
		DecimalFormat numberFormat = new DecimalFormat("0.00");
		int stopnieC = -70+index;
		double stopnieF = (((9.0/5.0)*stopnieC)+32);	
		return new String(stopnieC + " stopni C = " + numberFormat.format(stopnieF) + " stopni F");
	}
}