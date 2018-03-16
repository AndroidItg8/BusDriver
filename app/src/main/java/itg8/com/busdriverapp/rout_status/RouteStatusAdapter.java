package itg8.com.busdriverapp.rout_status;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import itg8.com.busdriverapp.R;
import itg8.com.busdriverapp.admin_map.Type;

/**
 * Created by Android itg 8 on 3/16/2018.
 */

public class RouteStatusAdapter extends RecyclerView.Adapter<RouteStatusAdapter.StatusViewHolder> {


    private final Context context;
    private final Type type;
    private final List<Object> list;

    public RouteStatusAdapter(Context context, Type type, List<Object> list) {

        this.context = context;
        this.type = type;
        this.list = list;
    }

    @Override
    public StatusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_route_status,parent,false);

        return new StatusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StatusViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class StatusViewHolder extends RecyclerView.ViewHolder {
        public StatusViewHolder(View itemView) {
            super(itemView);
        }
    }
}
