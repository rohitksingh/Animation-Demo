package rohitksingh.com.androidanimationdemo;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {


    public Context context;
    public List<ImageModel> list;

    public ImageAdapter(Context context, List<ImageModel> list)
    {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.image_item_layout,viewGroup,false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder imageHolder, int i) {

        ImageModel model = list.get(i);
        imageHolder.imageView.setImageResource(model.getImagePath());
        imageHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    private void startActivity()
    {
        Intent i = new Intent(context, DetailActivity.class);

        if(Build.VERSION.SDK_INT>20)
        {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity)context);
            context.startActivity(i,options.toBundle());
        }
        else {
            context.startActivity(i);
        }

    }

    public class ImageHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image);
        }
    }

}
