package lucas.client.service.sqlite;
import android.database.sqlite.*;
import android.content.*;

public class Core extends SQLiteOpenHelper
{
	public static String name = "myDB.db";
	
	public Core(Context c){
		super(c, name, null, 2);
	}
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		// TODO: Implement this method
		db.execSQL("CREATE TABLE produtos " +
		           "(id integer primary key autoincrement, loc TEXT, prod TEXT, quant TEXT, valor TEXT, payType TEXT, troco TEXT);");
		db.execSQL("CREATE TABLE dinheiro (id integer primary key autoincrement, money TEXT);");
		db.execSQL("CREATE TABLE operador (id integer primary key autoincrement, operador TEXT);");
		db.execSQL("CREATE TABLE fundo (id integer primary key autoincrement, fundo TEXT);");
		db.execSQL("CREATE TABLE sangria (id integer primary key autoincrement, valor TEXT, motivo TEXT);");
		db.execSQL("CREATE TABLE eloD (id integer primary key autoincrement, eloD TEXT);");
		db.execSQL("CREATE TABLE eloC (id integer primary key autoincrement, eloC TEXT);");
		db.execSQL("CREATE TABLE visaD (id integer primary key autoincrement, visaD TEXT);");
		db.execSQL("CREATE TABLE visaC (id integer primary key autoincrement, visaC TEXT);");
		db.execSQL("CREATE TABLE masterD (id integer primary key autoincrement, masterD TEXT);");
		db.execSQL("CREATE TABLE masterC (id integer primary key autoincrement, masterC TEXT);");
		db.execSQL("CREATE TABLE hiper (id integer primary key autoincrement, hiper TEXT);");
		db.execSQL("CREATE TABLE hiperC (id integer primary key autoincrement, hiperC TEXT);");
		db.execSQL("CREATE TABLE cabal (id integer primary key autoincrement, cabal TEXT);");
		db.execSQL("CREATE TABLE pix (id integer primary key autoincrement, pix TEXT);");
		db.execSQL("CREATE TABLE verde (id integer primary key autoincrement, verde TEXT);");
		db.execSQL("CREATE TABLE person (id integer primary key autoincrement, masterD TEXT);");
		db.execSQL("CREATE TABLE soro (id integer primary key autoincrement, soro TEXT);");
		db.execSQL("CREATE TABLE ouro (id integer primary key autoincrement, ouro TEXT);");
		db.execSQL("CREATE TABLE banrisul (id integer primary key autoincrement, banrisul TEXT);");
		db.execSQL("CREATE TABLE banriC (id integer primary key autoincrement, banriC TEXT);");
		db.execSQL("CREATE TABLE banes (id integer primary key autoincrement, banes TEXT);");
		db.execSQL("CREATE TABLE americ (id integer primary key autoincrement, americ TEXT);");
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
		p1.execSQL("DROP TABLE IF EXISTS");
	}

}
