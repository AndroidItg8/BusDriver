package itg8.com.busdriverapp.admin_map;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import itg8.com.busdriverapp.R;
import itg8.com.busdriverapp.home.HomeFragment;
import itg8.com.busdriverapp.rout_status.RouteStatusFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdminMapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdminMapFragment extends Fragment implements OnMapReadyCallback, View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    Unbinder unbinder;


    @BindView(R.id.lbl_halts)
    TextView lblHalts;
    @BindView(R.id.lbl_halts_value)
    TextView lblHaltsValue;
    @BindView(R.id.ll_halts)
    LinearLayout llHalts;
    @BindView(R.id.lbl_skip)
    TextView lblSkip;
    @BindView(R.id.lbl_skip_value)
    TextView lblSkipValue;
    @BindView(R.id.ll_skip)
    LinearLayout llSkip;
    @BindView(R.id.lbl_children)
    TextView lblChildren;
    @BindView(R.id.lbl_children_value)
    TextView lblChildrenValue;
    @BindView(R.id.ll_children)
    LinearLayout llChildren;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private GoogleMap mMap;


    public AdminMapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdminMapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdminMapFragment newInstance(String param1, String param2) {
        AdminMapFragment fragment = new AdminMapFragment();
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
        View view = inflater.inflate(R.layout.fragment_admin_map, container, false);
        unbinder = ButterKnife.bind(this, view);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
         init();
        return view;
    }

    private void init() {
        llChildren.setOnClickListener(this);
        llHalts.setOnClickListener(this);
        llSkip.setOnClickListener(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        Type type = null;
        switch (view.getId())
        {
            case R.id.ll_children:
                type= Type.CHILDREN;
                changeChildrenTextViewColor();
                break;
            case R.id.ll_halts:
                type = Type.HALTS;
                changeHaltsTextViewColor();
                break;
            case R.id.ll_skip:
                type = Type.HALTS;
                changeSkipTextViewColor();
                break;

        }
        openListFragment(type);
    }

    private void openListFragment(Type type) {

        FragmentManager fm = getActivity().getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.frame_container,  RouteStatusFragment.newInstance(type, ""), RouteStatusFragment.class.getSimpleName()).commit();

    }

    private void changeChildrenTextViewColor() {
        llChildren.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.colorBlueLight));
        llSkip.setBackgroundColor(Color.WHITE);
        llHalts.setBackgroundColor(Color.WHITE);
    }
    private void changeHaltsTextViewColor() {
        llHalts.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.colorBlueLight));
        llSkip.setBackgroundColor(Color.WHITE);
        llChildren.setBackgroundColor(Color.WHITE);
    }
    private void changeSkipTextViewColor() {
        llSkip.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.colorBlueLight));
        llChildren.setBackgroundColor(Color.WHITE);
        llHalts.setBackgroundColor(Color.WHITE);
    }


}
