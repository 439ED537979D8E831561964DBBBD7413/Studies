package in.co.khuranasales.khuranasales.NewLaunches;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import in.co.khuranasales.khuranasales.Activity_Login;
import in.co.khuranasales.khuranasales.AppConfig;
import in.co.khuranasales.khuranasales.AppController;
import in.co.khuranasales.khuranasales.Buy_Now_Activity;
import in.co.khuranasales.khuranasales.Final_Cart;
import in.co.khuranasales.khuranasales.LinearLayoutManagerWithSmoothScroller;
import in.co.khuranasales.khuranasales.MainActivity;
import in.co.khuranasales.khuranasales.NotificationUserList;
import in.co.khuranasales.khuranasales.Product;
import in.co.khuranasales.khuranasales.R;
import in.co.khuranasales.khuranasales.SoldItemPromotersActivity;
import in.co.khuranasales.khuranasales.notification.NotificationActivity;

public class newLaunchesActivity extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;
    private TextView textView13;
    private AppConfig appConfig;
    private TextView textView14;
    public DrawerLayout mDrawer;
    public ActionBarDrawerToggle mDrawerToggle;
    public Toolbar toolbar;

    public RecyclerView new_launch_recycler;
    public newLaunchAdapter adapter_new_launch ;
    public LinearLayoutManagerWithSmoothScroller layoutManagerWithSmoothScroller;
    public ArrayList<Product> products;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appConfig = new AppConfig(getApplicationContext());
        products = new ArrayList<>();
        setContentView(R.layout.new_launch_activity_layout);
        new_launch_recycler = (RecyclerView)findViewById(R.id.new_launch_recycler);
        new_launch_recycler.setHasFixedSize(true);
        layoutManagerWithSmoothScroller = new LinearLayoutManagerWithSmoothScroller(getApplicationContext());
        new_launch_recycler.setLayoutManager(layoutManagerWithSmoothScroller);
        adapter_new_launch = new newLaunchAdapter(products,this);
        new_launch_recycler.setAdapter(adapter_new_launch);
        adapter_new_launch.notifyDataSetChanged();
        new LoadOutbox().execute();
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle("Khurana Sales");
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(true);
            }
        }
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        set_drawer_listeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_my_cart,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void set_drawer_listeners()
    {
        textView1 = (TextView) findViewById(R.id.login);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (appConfig.isLogin()) {
                    mDrawer.closeDrawers();
                    Toast.makeText(getApplicationContext(), "Already Logged In As " + appConfig.getUser_name(), Toast.LENGTH_LONG).show();
                } else {
                    mDrawer.closeDrawers();
                    Intent intent = new Intent(getApplicationContext(), Activity_Login.class);
                    startActivity(intent);

                }
            }
        });
        textView2 = (TextView) findViewById(R.id.signup);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.closeDrawers();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        textView3 = (TextView) findViewById(R.id.cart);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (appConfig.isLogin()) {
                    mDrawer.closeDrawers();
                    Intent intent = new Intent(getApplicationContext(), Buy_Now_Activity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please Login Before Proceedig ...", Toast.LENGTH_LONG).show();
                }
            }
        });
        textView4 = (TextView) findViewById(R.id.acc);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (appConfig.isLogin()) {
                    mDrawer.closeDrawers();
                    Intent intent = new Intent(getApplicationContext(), Final_Cart.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please Login Before Proceedig ...", Toast.LENGTH_LONG).show();
                }
            }
        });

        textView5 = (TextView) findViewById(R.id.setPasscode);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.closeDrawers();
                Toast.makeText(getApplicationContext(), "Soon.....", Toast.LENGTH_LONG).show();
            }
        });


        textView6 = (TextView) findViewById(R.id.forgotKey);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.closeDrawers();
                Toast.makeText(getApplicationContext(), "Soon.....", Toast.LENGTH_LONG).show();
            }
        });


        textView7 = (TextView) findViewById(R.id.help);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.closeDrawers();
                Toast.makeText(getApplicationContext(), "Soon.....", Toast.LENGTH_LONG).show();
            }
        });


        textView8 = (TextView) findViewById(R.id.share);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.closeDrawers();
                Toast.makeText(getApplicationContext(), "Soon.....", Toast.LENGTH_LONG).show();
            }
        });

        textView9 = (TextView) findViewById(R.id.contact);
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.closeDrawers();
                Toast.makeText(getApplicationContext(), "Soon.....", Toast.LENGTH_LONG).show();
            }
        });

        textView10 = (TextView) findViewById(R.id.about);
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.closeDrawers();
                Toast.makeText(getApplicationContext(), "Soon.....", Toast.LENGTH_LONG).show();
            }
        });

        textView11 = (TextView) findViewById(R.id.logout);
        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.closeDrawers();
                appConfig.setStatus_login(false);
                Toast.makeText(getApplicationContext(), "Logged Out " + appConfig.getUser_name(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Activity_Login.class);
                startActivity(intent);
            }
        });
        textView12 = (TextView) findViewById(R.id.notify);
        textView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.closeDrawers();
                Intent intent = new Intent(getApplicationContext(), NotificationUserList.class);
                startActivity(intent);
            }
        });
        textView13 = (TextView) findViewById(R.id.promoters);
        textView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.closeDrawers();
                Intent intent = new Intent(getApplicationContext(), SoldItemPromotersActivity.class);
                startActivity(intent);
            }
        });
        textView14 = (TextView) findViewById(R.id.notification);
        textView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.closeDrawers();
                Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
                startActivity(intent);
            }
        });
    }

    class LoadOutbox extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Final_Cart.items.clear();
        }
        @Override
        protected Void doInBackground(String... params)  {
            Log.d("URL:",AppConfig.get_new_launches);
            JsonArrayRequest new_launch_request = new JsonArrayRequest(AppConfig.get_new_launches,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.d("True Response", response.toString());
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject obj = response.getJSONObject(i);
                                    Product pro = new Product();
                                    pro.set_Name(obj.getString("Name"));
                                    pro.set_Stock(obj.getInt("stock"));
                                    pro.setPrice_mop(obj.getInt("mop"));
                                    pro.setPrice_mrp(obj.getInt("mrp"));
                                    pro.setPrice_ks(obj.getInt("ksprice"));
                                    pro.setProduct_id(obj.getInt("product_id"));
                                    pro.set_link(obj.getString("link"));
                                    products.add(pro);
                                    adapter_new_launch.notifyDataSetChanged();
                                }
                                catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            VolleyLog.d("VOLLEY ERROR:-", "Error: " + error.getMessage());
                        }
                    });
            new_launch_request.setRetryPolicy(new DefaultRetryPolicy(
                    DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            AppController.getInstance().addToRequestQueue(new_launch_request);
            return null;
        }
        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute() {
            // dismiss the dialog after getting all products


        }
    }

    }
