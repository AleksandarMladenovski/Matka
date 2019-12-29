package com.extremedesign.matka.ui.fragment;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;

        import androidx.annotation.NonNull;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentTransaction;
        import androidx.viewpager.widget.ViewPager;

        import com.afollestad.viewpagerdots.DotsIndicator;
        import com.extremedesign.matka.FullScreenDialog;
        import com.extremedesign.matka.MainActivity;
        import com.extremedesign.matka.R;
        import com.extremedesign.matka.adapter.HomeViewPagerAdapter;
        import com.extremedesign.matka.listener.OpenImageListener;

public class HistoryFragment extends Fragment {
    ViewPager viewPager;
    ViewPager.OnPageChangeListener listener;
    public HistoryFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_history, container, false);
        viewPager = root.findViewById(R.id.home_view_pager);
        HomeViewPagerAdapter viewPagerAdapter = new HomeViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        DotsIndicator dotsIndicator=root.findViewById(R.id.dots);
        dotsIndicator.attachViewPager(viewPager);

//        listener =  initListener();
//        viewPager.addOnPageChangeListener(listener);
//        int timer = 6000;
//        Thread photoChanger= new ThreadChangeFragmentViewPager(timer);
//        photoChanger.start();
//        viewPager.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                if(b){
//                    photoChanger.start();
//                }
//                else{
//                    photoChanger.stop();
//                }
//            }
//        });


        return root;

    }

    private ViewPager.OnPageChangeListener initListener() {
        return  new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    class ThreadChangeFragmentViewPager extends Thread{
        private int timer;

        public ThreadChangeFragmentViewPager(int timer) {
            this.timer = timer;
        }

        @Override
        public void run() {
            super.run();
            try {
                while(true){
                    Thread.sleep(timer);
                    int pos = viewPager.getCurrentItem();
                    if(pos==2){
                        pos=-1;
                    }
                    final int position=pos+1;
                    viewPager.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onPageSelected(position);
                        }
                    });

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}