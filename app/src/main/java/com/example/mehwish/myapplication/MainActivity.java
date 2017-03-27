package com.example.mehwish.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends ListActivity {

    private String[] listview_names =  {
            "Ammar Mazhar","Ayesha Ali","Bilal Ahmad","Bisma Ch","Chandni","Chand","Daania Amir","Daanish",
            "Eijaz Ch","Eman","Fayaz Ahmad","Fatima Batool","Gazmir ","Guryia","Haroon","Hamna Awais",
            "Ifran Azim","Ifrah Amjad","Junaid Akram","Joddat","Kashifah Omar","Kashif Zia","Laila","Luqman Bhai",
            "Mudassar Muzzamil","Mehwish Bilal","Naila","Numan Zia","Omar Akram","Owais Ahmad","Parvaiz Alahi","Pari",
            "Qirat Manzoor","Qasim Altaf","Rehan Ahmar","Rubab Batool","Sheheryar","Shanza Khan","Tanverr Basheer","Tania",
            "Umair Iqbal","Usman","Vardah Khan","Varisha","Waris Shah","Wajiha Fatima","Wassim Badami","Yaaseen","Yasir Iqbal",
            "Yusra Iqbal","Zaafir Iqbal","Zanobia Ahmad"};
    private String[] listview_Phones =  {"+923007346525","+923216853836","+923017645856","+923458734762","+923557346525","+923005676525"
    ,"+923007346123","+923224346525","+923034546525","+923012346525","+923005676525","+923008765525","+923007654525","+923007346525",
    "+923007346525","+923007346525","+9230073478925","+923007346785","+923007346500","+923007346501","+923007346225","+923007346555",
    "+923008756874","+923005674575","+92300734876","+923007340000","+923000046525","+923000456734","+9232256784566","+923057656786","+9233216853836",
    "+923007345675","+9230098765432","+923007376575","+923001122335","+923000006525","+923007340000","+923007987625","+92300734876785",
    "+923007345265","+923007347654","+923007346525","+923215067854","+923056699765","+923004567845","+923015678456","+923456545673","+923000006525",
    "+923007346665","+923007656873","+923008737654","+923007347655"};
    private static int[] listview_images = {R.drawable.shape,R.drawable.shape1,R.drawable.shape2,R.drawable.shape3};
    static Context mcontext;
    private ListView lv;
    private static ArrayList<String> array_sort;
    private static ArrayList<String> array_sort1;
    private static ArrayList<Integer> Values;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(android.R.id.list);
        array_sort=new ArrayList<String> (Arrays.asList(listview_names));
        array_sort1=new ArrayList<String>();
        Values=new ArrayList<Integer>();
        for (int index = 0; index < listview_Phones.length; index++)
        {
            array_sort1.add(listview_Phones[index]);
        }

        setListAdapter(new bsAdapter(this));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0,
                                    View arg1, int position, long arg3)
            {
                Toast.makeText(getApplicationContext(), array_sort.get(position),
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),OPEN.class);
                intent.putExtra("KEY_StringName",array_sort.get(position));
                intent.putExtra("KEY_StringName1",array_sort1.get(position));
                TextView t=(TextView)findViewById(R.id.imageview);
                intent.putExtra("KEY",Values.get(position).toString());
                StringBuilder sb = new StringBuilder();
                String input=array_sort.get(position).toString();
                for(String s : input.split(" ")){
                    sb.append(s.charAt(0));
                }

                intent.putExtra("KEY_StringName2",sb.toString());
                startActivity(intent);
            }
        });
    }
    public static class bsAdapter extends BaseAdapter
    {
        Activity cntx;
        public bsAdapter(Activity context)
        {
            // TODO Auto-generated constructor stub
            this.cntx=context;
        }

        public int getCount()
        {
            // TODO Auto-generated method stub
            return array_sort.size();
        }
        @Override

        public Object getItem(int position)
        {
            // TODO Auto-generated method stub
            return array_sort.get(position);
        }

        public long getItemId(int position)
        {
            // TODO Auto-generated method stub
            return array_sort.size();
        }

        public View getView(final int position, View convertView, ViewGroup parent)
        {
            View row=null;
            LayoutInflater inflater=cntx.getLayoutInflater();
            row=inflater.inflate(R.layout.list_item, null);
            TextView tv = (TextView) row.findViewById(R.id.title);
            tv.setText(array_sort.get(position));
            TextView tv1 = (TextView) row.findViewById(R.id.title1);
            tv1.setText(array_sort1.get(position));
            TextView img = (TextView) row.findViewById(R.id.imageview);
            Random generator=new Random();
            int indx=generator.nextInt(listview_images.length);
            Values.add(position,indx);
            img.setBackgroundResource(listview_images[indx]);
            StringBuilder sb = new StringBuilder();
            String input=tv.getText().toString();
            for(String s : input.split(" ")){
                sb.append(s.charAt(0));
            }
            img.setText(sb);
            return row;
        }
    }
}
