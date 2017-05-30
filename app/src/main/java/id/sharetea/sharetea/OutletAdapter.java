package id.sharetea.sharetea;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class OutletAdapter extends RecyclerView.Adapter<OutletAdapter.MyViewHolder> {

    private List<Product> itemList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView address;
        public TextView floor;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.item_name);
            address = (TextView) view.findViewById(R.id.address);
            floor = (TextView) view.findViewById(R.id.floor);
            image = (ImageView) view.findViewById(R.id.img_item);
        }
    }
    FirebaseStorage storage = FirebaseStorage.getInstance();


    public OutletAdapter(Context context, List<Product> moviesList) {
        this.itemList = moviesList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_outlet, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product item = itemList.get(position);
        holder.name.setText("Outlet "+item.getName());
        holder.address.setText("Address "+item.getName());
        holder.floor.setText("Floor "+item.getName());

        StorageReference gsReference = storage.getReferenceFromUrl("gs://sharetea-39ca6.appspot.com/outlet"+ item.getImage());
        Glide.with(context)
                .using(new FirebaseImageLoader())
                .load(gsReference)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}