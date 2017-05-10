package ru.ingos.digitalmedicine.ui.activities;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.mvp.presenters.FragmentBinderPresenter;
import ru.ingos.digitalmedicine.mvp.presenters.MainMenuPresenter;
import ru.ingos.digitalmedicine.mvp.views.FragmentBinderView;
import ru.ingos.digitalmedicine.mvp.views.MainMenuView;
import ru.ingos.digitalmedicine.ui.fragments.*;


public class MainActivity extends MvpAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, FragmentBinderView, MainMenuView {

    @BindView(R.id.actibity_main_drawer_layout) DrawerLayout dlSideMenu;
    @BindView(R.id.activity_main_toolbar) Toolbar tAppBar;
    @BindView(R.id.acntivity_main_nav_view) NavigationView nvMenuView;

    @InjectPresenter(type = PresenterType.GLOBAL, tag = "FragmentBinderPresenter") FragmentBinderPresenter prFragmentBinder;
    @InjectPresenter(type = PresenterType.GLOBAL, tag = "MainMenuPresenter") MainMenuPresenter prMainMenu;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        setSupportActionBar(this.tAppBar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dlSideMenu, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dlSideMenu.addDrawerListener(toggle);
        toggle.syncState();

        nvMenuView.setNavigationItemSelectedListener(this);

        //Перехватываю клик по шапке меню
        View headerView = nvMenuView.getHeaderView(0);
        LinearLayout header = (LinearLayout) headerView.findViewById(R.id.nav_header);
        header.setOnClickListener(this);
    }

    /**
     * Заменяет фрагмент в главном контейнере
     * В качестве тега используется имя класса
     * @param fragmentClass класс фрагмента, который необходимо добавить
     */
    @Override
    public void bindFragment(Class<? extends MvpFragment> fragmentClass, boolean add_to_back){
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        try {
            trans.replace(R.id.fragment_container, fragmentClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(add_to_back)trans.addToBackStack(null);
        trans.commit();
    }

    public void setFragment(Class<? extends MvpFragment> fragment){
        this.prFragmentBinder.bindFragment(fragment, true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.actibity_main_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        Class<? extends MvpFragment> fragmentClass = null;

        if (id == R.id.nav_clinics) {
            fragmentClass = FragmentClinicList.class;
        } else if (id == R.id.nav_main) {
            fragmentClass = FragmentMain.class;
        } else if (id == R.id.nav_history) {
            fragmentClass = FragmentHistory.class;
        } else if (id == R.id.nav_registry) {
            fragmentClass = FragmentRegistry.class;
        } else if (id == R.id.nav_settings) {
            fragmentClass = FragmentSettings.class;
        } else if (id == R.id.nav_recipes) {
            fragmentClass = FragmentRecipes.class;
        }

        if(fragmentClass != null){
            this.prFragmentBinder.bindFragment(fragmentClass, false);
            this.prMainMenu.changeSelection(fragmentClass);
        }

        this.dlSideMenu.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.dlSideMenu.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy(){
        unbinder.unbind();

        super.onDestroy();
    }

    //перехватывает клик по шапке меню
    @Override
    public void onClick(View v) {
        this.prFragmentBinder.bindFragment(FragmentPrivateRoom.class, false);
        this.prMainMenu.diselectAll();
        this.dlSideMenu.closeDrawer(GravityCompat.START);
    }

    private void diselectAllMenuItems(){
        Menu menu = nvMenuView.getMenu();
        for(int i = 0; i<menu.size(); i++){
            menu.getItem(i).setChecked(false);
        }
    }

    @Override
    public void replaceCheck(int num) {
        this.diselectAllMenuItems();
        Menu menu = nvMenuView.getMenu();
        if(num>=0 && num<menu.size()) menu.getItem(num).setChecked(true);
    }
}
