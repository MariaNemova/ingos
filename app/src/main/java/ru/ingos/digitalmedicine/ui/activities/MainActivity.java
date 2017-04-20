package ru.ingos.digitalmedicine.ui.activities;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;


import butterknife.ButterKnife;
import ru.ingos.digitalmedicine.R;
import ru.ingos.digitalmedicine.ui.fragments.*;

/**
 * Экран является точкой входа в приложение, содержит меню. Все экраны, которые могут быть вызваны из меню,
 * представляют собой фрагменты, которые заплняют FrameLayout на этом экране. Каждый фрагмент представляет собой
 * обособленную сущность и имеет свой собтвенный жизненый цикл.
 * Такой подход выбран из-за того, что меню должно присутствовать на всех экранах. Избегаем дубликатов кода, используем
 * DRY концепцию.
 *
 * TODO: реализовать на этом экране проверку входа. Если пользователь не авторизован, то выбрасывать его на экран входа
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    //Теги для фргментов, чтобы определять, храняться ли они в FragmentManager и не создавать дополнительных сущностей.


    //НЕ ЗАБЫВАТЬ! Освобождать все ссылки при остановке активности! Необходимо для сборки мусора.
    private DrawerLayout drawer;
    private Toolbar appBar;
    private Class<? extends FragmentBase> curFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.appBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.appBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Перехватываю клик по шапке меню
        View header_view = navigationView.getHeaderView(0);
        LinearLayout header = (LinearLayout) header_view.findViewById(R.id.nav_header);
        header.setOnClickListener(this);
    }

    @Override
    protected void onStart(){
        super.onStart();

        //Cразу после запуска, показываю главный фргмент, делая его активным
        //TODO: Добавить проверку авторизации

        this.bindFragment(this.curFragment==null?FragmentMain.class:this.curFragment, false);
        NavigationView view = (NavigationView)findViewById(R.id.nav_view);
        view.getMenu().getItem(0).setChecked(true);
    }

    /**
     * Заменяет фрагмент в главном контейнере
     * В качестве тега используется имя класса
     * @param fragmentClass класс фрагмента, который необходимо добавить
     */
    public void bindFragment(Class<? extends FragmentBase> fragmentClass, boolean add_to_back){
        try {
            FragmentTransaction trans = getFragmentManager().beginTransaction();
            trans.replace(R.id.fragment_container, fragmentClass.newInstance(),fragmentClass.getName());
            if(add_to_back && this.curFragment != fragmentClass)trans.addToBackStack(null);
            trans.commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        this.curFragment = fragmentClass;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_clinics) {
            this.bindFragment(FragmentList.class, false);
        } else if (id == R.id.nav_main) {
            this.bindFragment(FragmentMain.class, false);
        } else if (id == R.id.nav_history) {
            this.bindFragment(FragmentHistory.class, false);
        } else if (id == R.id.nav_registry) {
            this.bindFragment(FragmentRegistry.class, false);
        } else if (id == R.id.nav_settings) {
            this.bindFragment(FragmentSettings.class, false);
        }

        this.drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.drawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        this.drawer = null;
        this.appBar = null;
        this.curFragment = null;
    }

    //перехватывает клик по шапке меню
    @Override
    public void onClick(View v) {
        this.bindFragment(FragmentPrivateRoom.class, true); //показываю окно
        this.drawer.closeDrawer(GravityCompat.START); //скрываю меню

        NavigationView view = (NavigationView)findViewById(R.id.nav_view);
        Menu menu = view.getMenu();
        for(int i = 0; i<menu.size(); i++){
            menu.getItem(i).setChecked(false);
        }
    }

    public void cahngeToolbar(int res_id){
        if(getSupportActionBar()!=null)
            getSupportActionBar().setTitle(res_id);
    }
}
