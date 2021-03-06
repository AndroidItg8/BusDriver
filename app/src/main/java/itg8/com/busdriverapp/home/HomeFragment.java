package itg8.com.busdriverapp.home;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import itg8.com.busdriverapp.R;
import itg8.com.busdriverapp.admin_map.AdminMapFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.lbl_admin_name)
    TextView lblAdminName;
    @BindView(R.id.lbl_admin_detail)
    TextView lblAdminDetail;
    @BindView(R.id.lbl_pick_up)
    TextView lblPickUp;
    @BindView(R.id.img_direction)
    ImageView imgDirection;
    @BindView(R.id.lbl_source_location)
    TextView lblSourceLocation;
    @BindView(R.id.lbl_designation_location)
    TextView lblDesignationLocation;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.lbl_time_remaining)
    TextView lblTimeRemaining;
    @BindView(R.id.rl_location)
    RelativeLayout rlLocation;
    @BindView(R.id.img_bus)
    ImageView imgBus;
    @BindView(R.id.lbl_bus_number)
    TextView lblBusNumber;
    @BindView(R.id.lbl_halts)
    TextView lblHalts;
    @BindView(R.id.lbl_halts_value)
    TextView lblHaltsValue;
    @BindView(R.id.lbl_skip)
    TextView lblSkip;
    @BindView(R.id.lbl_skip_value)
    TextView lblSkipValue;
    @BindView(R.id.lbl_children)
    TextView lblChildren;
    @BindView(R.id.lbl_children_value)
    TextView lblChildrenValue;
    @BindView(R.id.ll_children)
    LinearLayout llChildren;
    @BindView(R.id.lbl_let_start)
    TextView lblLetStart;
    @BindView(R.id.rl_card)
    RelativeLayout rlCard;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Context context;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        lblLetStart.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        Fragment  fragment =null;
        switch (view.getId())
        {
            case R.id.lbl_let_start:
                fragment= AdminMapFragment.newInstance("", "");


                break;


        }
        callFragment(fragment);
    }

    private void callFragment(Fragment fragment) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frame_container, fragment, fragment.getClass().getSimpleName()).commit();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

    }
}
