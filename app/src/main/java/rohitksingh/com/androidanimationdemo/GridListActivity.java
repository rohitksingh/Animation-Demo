package rohitksingh.com.androidanimationdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;

public class GridListActivity extends AppCompatActivity{


    private List<ImageModel> list;
    private RecyclerView rv;
    private ImageAdapter imageAdapter;


    @Override
    public void onCreate(Bundle savedInstaceState)
    {
        super.onCreate(savedInstaceState);

        setSlideAnimaation();

        setContentView(R.layout.grid_list_activity);
        rv = (RecyclerView)findViewById(R.id.rv);

        imageAdapter = new ImageAdapter(GridListActivity.this,getList());

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(GridListActivity.this,2);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(imageAdapter);

    }




    private List<ImageModel> getList()
    {
        list = new ArrayList<ImageModel>();

        for(int i=0;i<20;i++) {
            ImageModel model = new ImageModel();
            model.setImagePath(R.drawable.ic_launcher_background);
            list.add(model);
        }

        return list;
    }

    private void setAnimation()
    {
        if(Build.VERSION.SDK_INT>20) {
            Explode explode = new Explode();
            explode.setDuration(1000);
            explode.setInterpolator(new DecelerateInterpolator());
            getWindow().setExitTransition(explode);
            getWindow().setEnterTransition(explode);
        }
    }


    private void setSlideAnimaation()
    {
        if(Build.VERSION.SDK_INT>20) {
            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.BOTTOM);
            slide.setDuration(400);
            slide.setInterpolator(new AccelerateDecelerateInterpolator());
            getWindow().setExitTransition(slide);
            getWindow().setEnterTransition(slide);
        }
    }


}
