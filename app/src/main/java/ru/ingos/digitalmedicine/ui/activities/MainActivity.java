package ru.ingos.digitalmedicine.ui.activities;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import ru.ingos.digitalmedicine.IngosApplication;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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

    @Override
    protected void onStart(){
        super.onStart();
        boolean startFromBeggining = getIntent().getBooleanExtra(IngosApplication.EXTRA_IS_FROM_BRGINING, false);
        if(startFromBeggining) this.bindFragment(FragmentMain.class, false);
    }

    /**
     * Метод меняет фрагменты в главном контейнере на MainActivity
     * Метод работает сразу с двумя классами фрагментов: Основным и из библиотеки support.v4
     * @param fragmentClass класс фрагмента на который необходимо заменить содержание контейнера
     * @param add_to_back необходимо ли добавлять на back_stack предыдущий фрагмент.
     */
    @Override
    public void bindFragmentSupport(Class fragmentClass, boolean add_to_back){
        if(Fragment.class.isAssignableFrom(fragmentClass)){
            bindFragmentV4(fragmentClass, add_to_back);
        }else if(getSupportFragmentManager().findFragmentByTag("SupportFragment") != null){
            android.support.v4.app.FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
            trans.remove(getSupportFragmentManager().findFragmentByTag("SupportFragment"));
            trans.commit();
        }

        if(MvpFragment.class.isAssignableFrom(fragmentClass)){
            bindFragment(fragmentClass, add_to_back);
        }else if(getFragmentManager().findFragmentByTag("MainFragment") != null){
            FragmentTransaction trans = getFragmentManager().beginTransaction();
            trans.remove(getFragmentManager().findFragmentByTag("MainFragment"));
            trans.commit();
        }
    }

    private void bindFragment(Class fragmentClass, boolean add_to_back){
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        try {
            //предупреждение необсановано. проверка проведена в вызывающем методе.
            trans.replace(R.id.fragment_container, ((Class<? extends MvpFragment>)fragmentClass).newInstance(), "MainFragment");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            Log.e(IngosApplication.DEBUG_TAG, "Instanitation exception!");
            e.printStackTrace();
        }
        if(add_to_back)trans.addToBackStack(null);
        trans.commit();
    }

    private void bindFragmentV4(Class fragmentClass, boolean add_to_back){
        android.support.v4.app.FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        try{
            //предупреждение необсановано. проверка проведена в вызывающем методе.
            trans.replace(R.id.fragment_container, ((Class<? extends MVP4Fragment>)fragmentClass).newInstance(), "SupportFragment");
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            Log.e(IngosApplication.DEBUG_TAG, "Instanitation exception!");
            e.printStackTrace();
        }
        if(add_to_back)trans.addToBackStack(null);
        trans.commit();
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

        Class fragmentClass = null;

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
