package h2020.mhealth4afrika.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import h2020.mhealth4afrika.R;
import h2020.mhealth4afrika.activities.ANCVisitsActivity;
import h2020.mhealth4afrika.activities.MainActivity;

public class ANCVisitsAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    String[] result;
    Context context;
    int[] imageId;

    public ANCVisitsAdapter(ANCVisitsActivity landing, String[] prgmNameList, int[] prgmImages) {

        result = prgmNameList;
        context = landing;
        imageId = prgmImages;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {

        return result.length;
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.landing_items, null);
        holder.tv = (TextView) rowView.findViewById(R.id.textView1);
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

//        rowView.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//
//                if (result[position].equals("Health Facilities")) {
//                    Toast.makeText(context, "You Clicked 1", Toast.LENGTH_LONG).show();
//
//                } else if (result[position].equals("ANC Visits")) {
//                    Toast.makeText(context, "You Clicked 2", Toast.LENGTH_LONG).show();
//
//                } else if (result[position].equals("Patients")) {
//                    Toast.makeText(context, "You Clicked 3", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        return rowView;
    }

    public class Holder {
        TextView tv;
        ImageView img;
    }
}
