package hynit.eida;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

public class Peluquero extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, fgTurnos.OnFragmentInteractionListener, estadoTurno.OnFragmentInteractionListener {
    JSONObject response, profile_pic_data, profile_pic_url;
    TextView user_name, user_email;
    ImageView user_picture;
    NavigationView navigation_view;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peluquero);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home Page");
        Intent intent = getIntent();
        String jsondata = intent.getStringExtra("jsondata");
        setNavigationHeader();    // call setNavigationHeader Method.
        setUserProfile(jsondata);  // call setUserProfile Method.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hay un total de x Clientes en espera", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigation_view.setNavigationItemSelectedListener(this);
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

    /*
        Set Navigation header by using Layout Inflater.
     */
    public void setNavigationHeader() {
        navigation_view = (NavigationView) findViewById(R.id.nav_view);
        View header = LayoutInflater.from(this).inflate(R.layout.nav_header_peluquero, null);
        navigation_view.addHeaderView(header);
        user_name = (TextView) header.findViewById(R.id.username);
        user_picture = (ImageView) header.findViewById(R.id.profile_pic);
        user_email = (TextView) header.findViewById(R.id.email);
    }

    /*
       Set User Profile Information in Navigation Bar.
     */
    public void setUserProfile(String jsondata) {
        try {
            response = new JSONObject(jsondata);
            user_email.setText(response.get("email").toString());
            user_name.setText(response.get("name").toString());
            profile_pic_data = new JSONObject(response.get("picture").toString());
            profile_pic_url = new JSONObject(profile_pic_data.getString("data"));
            Picasso.with(this).load(profile_pic_url.getString("url"))
                    .into(user_picture);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //   getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    public boolean onCreateOptionsMenuptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override

    public boolean onNavigationItemSelected(MenuItem item) {
// Handle navigation view item clicks here.
        int id = item.getItemId();
        //Creamos el fragment para poder cargar en el navigation activity drawer
        fgTurnos fragment = null;
        estadoTurno estadoturno = null;
        // Fragment fragment = null;
        Boolean FragmentoSeleccionado = false;

        if (id == R.id.nav_logout) {

// Handle the Logout Process
            LoginManager.getInstance().logOut();
            Intent intent = new Intent(Peluquero.this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_Turnos) {
            //Creamos fragmentos dinamicos
            fragment = new fgTurnos();
            // getSupportFragmentManager().beginTransaction().add(R.id.contenedor3,fragment).commit();
            FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
            transition.replace(R.id.contenedor4, fragment);
            transition.commit();
            FragmentoSeleccionado = true;
            if (FragmentoSeleccionado) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor4, fragment).commit();
            }
        } else if (id == R.id.nav_estado_turno) {
            //Creamos fragmentos dinamicos
            estadoturno = new estadoTurno();

            FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
            transition.replace(R.id.contenedor4, estadoturno);
            transition.commit();
            FragmentoSeleccionado = true;
            if (FragmentoSeleccionado) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor4, estadoturno).commit();
            }

        } else if (id == R.id.nav_staff) {


        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        // Este metodo lo que hace que valida el fragmento que se paso para luego reemplazarlo
//        if (FragmentoSeleccionado){
//            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor4,fragment).commit();
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

