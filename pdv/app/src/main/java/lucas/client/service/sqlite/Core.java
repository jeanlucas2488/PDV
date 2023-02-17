package lucas.client.service.sqlite;
import android.database.sqlite.*;
import android.content.*;

public class Core extends SQLiteOpenHelper
{
	public static String name = "myDB.db";
	
	public Core(Context c){
		super(c, name, null, 7);
	}
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		// TODO: Implement this method
		db.execSQL("create table produtos" +
		           "(id integer primary key autoincrement, loc TEXT, prod TEXT, quant TEXT, valor TEXT, payType TEXT, troco TEXT)");
		db.execSQL("create table dinheiro (id integer primary key autoincrement, money TEXT)");
		db.execSQL("create table operador (id integer primary key autoincrement, operador TEXT)");
		db.execSQL("create table fundo (id integer primary key autoincrement, fundo TEXT)");
		db.execSQL("create table sangria (id integer primary key autoincrement, valor TEXT, motivo TEXT)");
		db.execSQL("create table eloD (id integer primary key autoincrement, eloD TEXT)");
		db.execSQL("create table eloC (id integer primary key autoincrement, eloC TEXT)");
		db.execSQL("create table visaD (id integer primary key autoincrement, visaD TEXT)");
		db.execSQL("create table visaC (id integer primary key autoincrement, visaC TEXT)");
		db.execSQL("create table masterD (id integer primary key autoincrement, masterD TEXT)");
		db.execSQL("create table masterC (id integer primary key autoincrement, masterC TEXT)");
		db.execSQL("create table hiper (id integer primary key autoincrement, hiper TEXT)");
		db.execSQL("create table hiperC (id integer primary key autoincrement, hiperC TEXT)");
		db.execSQL("create table cabal (id integer primary key autoincrement, cabal TEXT)");
		db.execSQL("create table pix (id integer primary key autoincrement, pix TEXT)");
		db.execSQL("create table verde (id integer primary key autoincrement, verde TEXT)");
		db.execSQL("create table person (id integer primary key autoincrement, masterD TEXT)");
		db.execSQL("create table soro (id integer primary key autoincrement, soro TEXT)");
		db.execSQL("create table ouro (id integer primary key autoincrement, ouro TEXT)");
		db.execSQL("create table banrisul (id integer primary key autoincrement, banrisul TEXT)");
		db.execSQL("create table banriC (id integer primary key autoincrement, banriC TEXT)");
		db.execSQL("create table banes (id integer primary key autoincrement, banes TEXT)");
		db.execSQL("create table americ (id integer primary key autoincrement, americ TEXT)");
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
