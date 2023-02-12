package lucas.client.service.sqlite;
import android.content.*;
import android.database.sqlite.*;

public class DB
{
	SQLiteDatabase db;
	public DB(Context c){
		Core cor = new Core(c);
		db = cor.getWritableDatabase();
	}
	
}
