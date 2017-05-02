package com.example.priyanjul.acmjuit;


import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Priyanjul on 24-03-2017.
 */


public class ProjectsActivity extends Fragment {

    private RecyclerView rv;
    private ProjectsAdapter adapter;
    private List<Project> projectList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View v= inflater.inflate(R.layout.our_projects, container, false);
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.our_projects, null);
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        Toolbar toolbar=(Toolbar)root.findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);

        initCollapsingToolbar(root);

        rv = (RecyclerView)root.findViewById(R.id.recycler_view);
        projectList =  new ArrayList<>();
        adapter = new ProjectsAdapter(this , projectList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        rv.setLayoutManager(mLayoutManager);
        rv.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);

        prepareProjects();

        try{
            Glide.with(this).load(R.drawable.cover).into((ImageView)root.findViewById(R.id.backdrop));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return root;


    }

    private void initCollapsingToolbar(ViewGroup root) {

        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)root.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" on collapse title ");
        AppBarLayout appBarLayout = (AppBarLayout) root.findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("title1");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle("title2 ");
                    isShow = false;
                }

            }


        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareProjects() {
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        Project a = new Project("True Romance", 13, covers[0]);
        projectList.add(a);

        a = new Project("Xscpae", 8, covers[1]);
        projectList.add(a);

        a = new Project("Maroon 5", 11, covers[2]);
        projectList.add(a);

        a = new Project("Born to Die", 12, covers[3]);
        projectList.add(a);

        a = new Project("Honeymoon", 14, covers[4]);
        projectList.add(a);

        a = new Project("I Need a Doctor", 1, covers[5]);
        projectList.add(a);

        a = new Project("Loud", 11, covers[6]);
        projectList.add(a);

        a = new Project("Legend", 14, covers[7]);
        projectList.add(a);

        a = new Project("Hello", 11, covers[8]);
        projectList.add(a);

        a = new Project("Greatest Hits", 17, covers[9]);
        projectList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //
        //getActivity().getActionBar().hide();

    }


}
