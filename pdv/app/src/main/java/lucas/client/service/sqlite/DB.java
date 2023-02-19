package lucas.client.service.sqlite;
import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import java.util.*;
import lucas.client.service.etc.*;

public class DB
{
	SQLiteDatabase db;
	public DB(Context c){
		Core cor = new Core(c);
		db = cor.getWritableDatabase();
	}
	public void delEloD(){
		db.execSQL("delete from eloD");
	}
	public void delEloC(){
		db.execSQL("delete from eloC");
	}
	public void delVisaD(){
		db.execSQL("delete from visaD");
	}
	public void delVisaC(){
		db.execSQL("delete from visaC");
	}
	public void delMasterD(){
		db.execSQL("delete from masterD");
	}
	public void delMasterC(){
		db.execSQL("delete from masterC");
	}
	public void delHiper(){
		db.execSQL("delete from hiper");
	}
	public void delHiperC(){
		db.execSQL("delete from hiperC");
	}
	public void delCabal(){
		db.execSQL("delete from cabal");
	}
	public void delPix(){
		db.execSQL("delete from pix");
	}
	public void delVerde(){
		db.execSQL("delete from verde");
	}
	public void delSoro(){
		db.execSQL("delete from soro");
	}
	public void delPerson(){
		db.execSQL("delete from person");
	}
	public void delOuro(){
		db.execSQL("delete from ouro");
	}
	public void delBanric(){
		db.execSQL("delete from banrisul");
	}
	public void delBanriC(){
		db.execSQL("delete from banriC");
	}
	public void delBanes(){
		db.execSQL("delete from banes");
	}
	public void delAmeric(){
		db.execSQL("delete from americ");
	}
	public void moneyIn(String us){
		ContentValues ct = new ContentValues();
		ct.put("money", us);
		db.insert("dinheiro", null, ct);
	}
	public void eloDIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("eloD", us.getEloD());
		db.insert("eloD", null, ct);
	}
	public void eloCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("eloC", us.getEloC());
		db.insert("eloC", null, ct);
	}
	public void visaDIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("visaD", us.getVisaD());
		db.insert("visaD", null, ct);
	}
	public void visaCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("visaC", us.getVisaC());
		db.insert("visaC", null, ct);
	}
	public void masterDIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("masterD", us.getMasterD());
		db.insert("masterD", null, ct);
	}
	public void masterCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("masterC", us.getMasterC());
		db.insert("masterC", null, ct);
	}
	public void hiperIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("hiper", us.getHiper());
		db.insert("hiper", null, ct);
	}
	public void hiperCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("hiperC", us.getHiperC());
		db.insert("hiperC", null, ct);
	}
	public void cabalIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("cabal", us.getCabal());
		db.insert("cabal", null, ct);
	}
	public void pixIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("pix", us.getPix());
		db.insert("pix", null, ct);
	}
	public void verdeIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("verde", us.getVerde());
		db.insert("verde", null, ct);
	}
	public void soroIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("soro", us.getSoro());
		db.insert("soro", null, ct);
	}
	public void personIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("person", us.getPerson());
		db.insert("person", null, ct);
	}
	public void ouroIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("ouro", us.getOuro());
		db.insert("ouro", null, ct);
	}
	public void banriIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("banrisul", us.getbanric());
		db.insert("banrisul", null, ct);
	}
	public void banriCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("banriC", us.getBanriC());
		db.insert("banriC", null, ct);
	}
	public void banesIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("banes", us.getBanes());
		db.insert("banes", null, ct);
	}
	public void americIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("americ", us.getAmeric());
		db.insert("americ", null, ct);
	}
	public List<util> moFind(){
		ArrayList<util> arr = new ArrayList<util>();
		Cursor cs = db.rawQuery("select * from dinheiro", null);
		if(cs.moveToFirst()){
		do{
			util us = new util();
			us.setMoney(cs.getString(1));
			arr.add(us);
			
		}while(cs.moveToNext());
		}
		return arr;
	}
}
