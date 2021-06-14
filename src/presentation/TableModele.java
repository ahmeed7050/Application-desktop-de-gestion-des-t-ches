package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.entity.Tâche;

public class TableModele extends AbstractTableModel {
	
	
	private String titres[]= {"liste","description","Date limite","état"};
	private List<Tâche>liste;
	public TableModele(){
		liste=new ArrayList<>();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titres.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return liste.size();
	}

	@Override
	public Object getValueAt(int l, int c) {
		switch(c)
		{
		case 0:return liste.get(l).getNomDelisteAjouter();
		case 1:return liste.get(l).getDescription();
		case 2:return liste.get(l).getDateLimite();
		case 3:return liste.get(l).getEtat();
		
		
		}
		return null;
	}
	
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return titres[column];
	}
	
	public void chargerTable(List<Tâche>liste)
	{
		this.liste=liste;
		fireTableDataChanged();
	}

}
