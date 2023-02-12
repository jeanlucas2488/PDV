package lucas.client.service.sqlite;
import android.database.sqlite.*;
import android.content.*;

public class Core extends SQLiteOpenHelper
{
	public static String name = "myDB.sqlite";
	
	public Core(Context c){
		super(c, name, null, 1);
	}
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		// TODO: Implement this method
		db.execSQL("create table produtos" +
		           "(id integer primary key, loc text, prod text, quant text, valor text, payType text, troco text");
		db.execSQL("create table eloD(id integer primary key, eloD text");
		db.execSQL("create table eloC(id integer primary key, eloC text");
		db.execSQL("create table visaD(id integer primary key, visaD text");
		db.execSQL("create table visaC(id integer primary key, visaC text");
		db.execSQL("create table masterD(id integer primary key, masterD text");
		db.execSQL("create table masterC(id integer primary key, masterC text");
		db.execSQL("create table hiper(id integer primary key, hiper text");
		db.execSQL("create table hiperC(id integer primary key, hiperC text");
		db.execSQL("create table cabal(id integer primary key, cabal text");
		db.execSQL("create table pix(id integer primary key, pix text");
		db.execSQL("create table verde(id integer primary key, verde text");
		db.execSQL("create table person(id integer primary key, masterD text");
		db.execSQL("create table soro(id integer primary key, soro text");
		db.execSQL("create table ouro(id integer primary key, ouro text");
		db.execSQL("create table banrisul(id integer primary key, banrisul text");
		db.execSQL("create table banriC(id integer primary key, banriC text");
		db.execSQL("create table banes(id integer primary key, banes text");
		db.execSQL("create table americ(id integer primary key, americ text");
	}

	@Override
	public void onConfigure(SQLiteDatabase db)
	{
		// TODO: Implement this method
		super.onConfigure(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase p1, int p2, int p3)
	{
		// TODO: Implement this method
	}

}
