package lucas.client.service.caixa;

import android.app.*;
import android.os.*;
import lucas.client.service.*;
import android.widget.*;
import lucas.client.service.caixa.adapters.*;
import java.util.*;
import android.widget.AdapterView.*;
import android.view.*;

public class caixaMain extends Activity
{
List<String> lt = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		lt.add("Acessórios");
		GridView gd = findViewById(R.id.grid);
		gd.setAdapter(new gridAd(this, lt));
		gd.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					switch(p3){
						case 0:
							
							break;
					}
				}
		});
	}
	
}
