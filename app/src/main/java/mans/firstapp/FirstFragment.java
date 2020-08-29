package mans.firstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment
{
    View view;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    List<Fragment> fragments = new ArrayList<>();
    List<String> names = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        initViews();
    }

    private void initViews()
    {
        tabLayout = view.findViewById(R.id.tabs);
        viewPager2 = view.findViewById(R.id.viewpager);

        fragments.add(new Tab1());
        fragments.add(new Tab2());
        fragments.add(new Tab3());

        names.add("first");
        names.add("second");
        names.add("third");

        viewPager2.setAdapter(new TabsAdapter(this, fragments));
        new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy()
                {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position)
                    {
                        tab.setText(names.get(position));
                        tab.setIcon(R.drawable.sheep);
                    }
                }
        ).attach();
    }

    public class TabsAdapter extends FragmentStateAdapter
    {
        List<Fragment> fragments;

        public TabsAdapter(Fragment fragment, List<Fragment> fragments)
        {
            super(fragment);
            this.fragments = fragments;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position)
        {
            return fragments.get(position);
        }

        @Override
        public int getItemCount()
        {
            return fragments.size();
        }
    }
}