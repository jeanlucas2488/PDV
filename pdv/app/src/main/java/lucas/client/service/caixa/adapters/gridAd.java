package lucas.client.service.caixa.adapters;
import android.content.*;
import android.widget.*;
import java.util.*;
import lucas.client.service.*;
import android.view.*;
import android.widget.Gallery.*;

public class gridAd extends ArrayAdapter<String>
{
	Context c;
	List<String> lt;
	
	public gridAd(Context c2, List<String> lt2){
		super(c2, R.layout.adapter_main, lt2);
		this.c = c2;
		this.lt = lt2;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO: Implement this method
		LayoutInflater li = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
		View r = li.inflate(R.layout.adapter_main, parent, false);
		TextView tv = r.findViewById(R.id.tv);
		ImageView im = r.findViewById(R.id.im);
		if(lt.get(position).startsWith("C")){
			im.setImageResource(R.drawable.client);
		}
		if(lt.get(position).startsWith("A")){
			im.setImageResource(R.drawable.aces);
		}
		if(lt.get(position).startsWith("G")){
			im.setImageResource(R.drawable.gamer);
		}
		if(lt.get(position).startsWith("F")){
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(110, 100);
			//im.setLayoutParams(layoutParams);
			
			layoutParams.setMargins(40,40,0,25);
			im.setImageResource(R.drawable.func);
		}
		tv.setText(lt.get(position));
		return r;
	}
	
}
