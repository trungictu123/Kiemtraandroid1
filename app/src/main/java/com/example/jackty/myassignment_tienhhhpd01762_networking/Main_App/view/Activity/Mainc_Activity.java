package com.example.jackty.myassignment_tienhhhpd01762_networking.Main_App.view.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.model.url_sever;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.model.user_model;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.view.Activity.Login_Activity;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Login_Activity.view.fragment.Fragment_login_main;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Main_App.view.fragment.Fragment_aboutme;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Main_App.view.fragment.Fragment_baihoc;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Main_App.view.fragment.Fragment_kiemtra;
import com.example.jackty.myassignment_tienhhhpd01762_networking.Main_App.view.fragment.Fragment_topbxh;
import com.example.jackty.myassignment_tienhhhpd01762_networking.My_Account.view.fragment.Fragment_chagepass;
import com.example.jackty.myassignment_tienhhhpd01762_networking.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Mainc_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static FragmentManager fragmentManager;
    String data = "" ;
    RequestQueue requestQueue;
  public static   ArrayList<user_model> arrbundelget;

    TextView dr_user, dr_email;
 private static    BottomNavigationView navigation;






// thanh công cụ ========================================================>

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_hoc:
                    //
                    come_baihoc();
                    return true;
                case R.id.navigation_kiemtra:
                    //
                    come_kiemtra();
                    return true;
                case R.id.navigation_bangxephang:
                    //
                    come_bxh();
                    return true;
//                case R.id.navigation_acc:
//                    //
//                    come_myacc();
//                    return true;
            }
            return false;
        }

    };
    // ========================================================>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainc_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // anh xa
        innits();





        // thanh công cụ ========================================================>
          navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getSupportFragmentManager();

        if(savedInstanceState == null)
        {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.content, new Fragment_baihoc(),
                            "Fragment_baihoc").commit();
        }

        // bundle id from login activity========================================================>
     // Bundle extras = getIntent().getExtras();
       // String id_bundle = extras.getString("id");
       // Toast.makeText(this, "nhận bundle"+id_bundle, Toast.LENGTH_SHORT).show();
    String id_bundle = Fragment_login_main.id_user;
          Get1Acc(url_sever.Get1_acc+id_bundle);

// ========================================================================================>




        // drawer ========================================================>
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hview = navigationView.getHeaderView(0);
        dr_user = hview.findViewById(R.id.dr_user);
        dr_email = hview.findViewById(R.id.dr_email);



        navigationView.setNavigationItemSelectedListener(this);




        //========================================================>





    }

    private void innits() {
        arrbundelget = new ArrayList<user_model>();




    }

    // bắt sự kiện trở lại ========================================================>
    @Override
    public void onBackPressed() {
        Fragment Fragment_aboutme = fragmentManager.findFragmentByTag("Fragment_aboutme");
        Fragment Fragment_baihoc = fragmentManager.findFragmentByTag("Fragment_baihoc");
        Fragment Fragment_kiemtra = fragmentManager.findFragmentByTag("Fragment_kiemtra");
        Fragment Fragment_topbxh = fragmentManager.findFragmentByTag("Fragment_topbxh");
        Fragment Fragment_chagepass = fragmentManager.findFragmentByTag("Fragment_chagepass");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if(Fragment_aboutme != null)
        {
            come_baihoc();
        }
        else
        if (Fragment_chagepass != null)
        {
            come_baihoc();
        }

        else
        if (Fragment_kiemtra != null)
        {
            come_baihoc();
        }
        else
        if (Fragment_topbxh != null)
        {
            come_baihoc();
        }
        else
        if (Fragment_baihoc != null)
        {
           come_bxh();
        }

        else{

            super.onBackPressed();
//            //Khoi tao lai Activity main
//            Intent intent = new Intent(getApplicationContext(), Mainc_Activity.class);
//            startActivity(intent);
//            // kết thúc app
//            Intent startMain = new Intent(Intent.ACTION_MAIN);
//            startMain.addCategory(Intent.CATEGORY_HOME);
//            startActivity(startMain);
//            finish();
        }
    }
    //========================================================>


// sự kiện drawer nav ========================================================>

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.drawer_myacc) {
            //
            come_myacc();

        } else if (id == R.id.drawe_chagepass) {
            come_chagepass();

        } else if (id == R.id.drawe_logout) {
            startActivity(new Intent(getApplicationContext(),Login_Activity.class));

        } else if (id == R.id.drawer_share) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Trắc nghiệm Lái Xe A1");
            String sAux = "\nHãy thử ngay bài test A1 nào\n\n";
            sAux = sAux + "https://www.facebook.com/tyfancao \n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "Chọn ứng dụng "));


        } else if (id == R.id.drawer_send) {

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, arrbundelget.get(0).getEmail());
            intent.putExtra(Intent.EXTRA_CC, "tienhhhpd01762@fpt.edu.vn");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Phản hổi ứng dụng 'TRẮC NGHIỆM A1'");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //========================================================>


    // gọi các fragment ========================================================>

    private void come_baihoc()
    {
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                .replace(R.id.content, new Fragment_baihoc(),
                        "Fragment_baihoc").commit();

    }
    private void come_kiemtra()
    {
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                .replace(R.id.content, new Fragment_kiemtra(),
                        "Fragment_kiemtra").commit();

    }
    private void come_bxh()
    {
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                .replace(R.id.content, new Fragment_topbxh(),
                        "Fragment_topbxh").commit();

    }
    public void come_myacc()
    {
        fragmentManager
                .beginTransaction()
               // .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                .replace(R.id.content, new Fragment_aboutme(),
                        "Fragment_aboutme").commit();

    }
    private void come_chagepass()
    {
        fragmentManager
                .beginTransaction()
                // .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                .replace(R.id.content, new Fragment_chagepass(),
                        "Fragment_chagepass").commit();

    }
    // ========================================================>

    // lấy tài khoản đã đăng nhập ========================================================>
    private void Get1Acc(String url)
    {


        // Creates the Volley request queue
        requestQueue = Volley.newRequestQueue(getApplicationContext()) ;
        // Casts results into the TextView found within the main layout XML with id jsonData

        JsonObjectRequest obreg = new JsonObjectRequest(Request.Method.GET,url,
                new Response.Listener<JSONObject>()
                {


                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray jsarray =  response.getJSONArray("ketqua");


                            for (int i = 0; i < jsarray.length(); i++) {
                                JSONObject objitem = jsarray.getJSONObject(i);

                                String id = objitem.getString("id");
                                String user = objitem.getString("user");
                                String email = objitem.getString("email");
                                String phone = objitem.getString("phone");

                                String pass = objitem.getString("pass");











                               arrbundelget.add(new user_model(id,user,email,phone,pass));




                            }






                            // show du lieu
                          //  Toast.makeText(getApplicationContext(), arrbundelget.get(0).toString(), Toast.LENGTH_SHORT).show();

                            dr_user.setText(arrbundelget.get(0).getUser());
                            dr_email.setText(arrbundelget.get(0).getEmail());






                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                },
                // The final parameter overrides the method onErrorResponse() and passes VolleyError
                //as a parameter
                new Response.ErrorListener() {
                    @Override
                    // Handles errors that occur due to Volley
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );

        requestQueue.add(obreg);






    }
    //========================================================>

}
