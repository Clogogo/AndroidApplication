package com.example.calculator.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator.R;
import com.example.calculator.utility.DbMiddleware;
import com.google.android.material.navigation.NavigationView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    /*private DrawerLayout drawer;*/
    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    private TextView expr;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // id linking
        expr = findViewById(R.id.expr);
        result = findViewById(R.id.result);
        Button ce = findViewById(R.id.ce);
        Button openBrc = findViewById(R.id.openBrc);
        Button closeBrc = findViewById(R.id.closeBrc);
        Button div = findViewById(R.id.div);
        Button mul = findViewById(R.id.mul);
        Button minus = findViewById(R.id.minus);
        Button plus = findViewById(R.id.plus);
        Button dot = findViewById(R.id.dot);
        Button back = findViewById(R.id.back);
        Button equals = findViewById(R.id.equals);
        Button sin = findViewById(R.id.sin);
        Button cos = findViewById(R.id.cos);
        Button tan = findViewById(R.id.tan);
        Button pow = findViewById(R.id.pow);
        Button sqroot = findViewById(R.id.sqroot);
        //fact = findViewById(R.id.fact);

        //drawer

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);//navigation bar's item select korer jonno object create
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);//enable
        /*
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/


        Button zero = findViewById(R.id.zero);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);


        // Numbers
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("1", true);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("2", true);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("3", true);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("4", true);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("5", true);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("6", true);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("7", true);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("8", true);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("9", true);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("0", true);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr(".", true);
            }
        });


        // Operators
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("+", false);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("-", false);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("*", false);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("/", false);
            }
        });
        openBrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("(", false);
            }
        });
        closeBrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr(")", false);
            }
        });

        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expr.setText("");
                result.setText("");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = expr.getText().toString();
                if (!string.isEmpty()) {
                    expr.setText(string.substring(0, string.length() - 1));
                }
                result.setText("");
            }
        });

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("sin(", false);
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("cos(", false);
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("tan(", false);
            }
        });
        sqroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("sqrt(", false);
            }
        });
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendOnExpr("^", false);
            }
        });


        equals.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                try {
                    Expression expression = new ExpressionBuilder(expr.getText().toString()).build();
                    double reslt = expression.evaluate();
                    reslt = Math.round(reslt*100)/100.0d;
                    int intres = (int) reslt;
                    String inputExpr = expr.getText().toString();
                    String finalResult;
                    if (reslt == intres) {
                        result.setText(String.valueOf(intres));
                        finalResult = String.valueOf(intres);

                    } else {
                        result.setText(String.valueOf(reslt));
                        finalResult = String.valueOf(reslt);
                    }

                    try {
                        DbMiddleware dbM = new DbMiddleware(inputExpr, finalResult, "standardCalu");
                        dbM.writeDB();
                        Toast.makeText(MainActivity.this, "Stored in Database!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Failed to Store in Database!", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    result.setText("Invalid Op!");
                }
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem Item) {
        if (toggle.onOptionsItemSelected(Item))
            return true;
        return super.onContextItemSelected(Item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        if (menuItem.isChecked()) {
            drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        }

        int id = menuItem.getItemId();

        if (id == R.id.nav_standard) {
            /*Toast.makeText(this, "The Temp", Toast.LENGTH_SHORT).show();*/
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_temp) {
            /*Toast.makeText(this, "The Temp", Toast.LENGTH_SHORT).show();*/
            Intent intent = new Intent(getApplicationContext(), Temp.class);
            startActivity(intent);
        } else if (id == R.id.nav_weight) {
            Intent intent = new Intent(getApplicationContext(), Weight.class);
            startActivity(intent);
        } else if (id == R.id.nav_currency) {
            Intent intent = new Intent(getApplicationContext(), Currency.class);
            startActivity(intent);
        } else if (id == R.id.nav_length) {
            Intent intent = new Intent(getApplicationContext(), Length.class);
            startActivity(intent);
        } else if (id == R.id.nav_volume) {
            Intent intent = new Intent(getApplicationContext(), Volume.class);
            startActivity(intent);
        } else if (id == R.id.nav_us) {
            Intent intent = new Intent(getApplicationContext(), AboutUs.class);
            startActivity(intent);
        } else if (id == R.id.nav_history) {
            Intent intent = new Intent(getApplicationContext(), History.class);
            startActivity(intent);
        } else if (id == R.id.nav_exit) {
            finish();
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }

    void appendOnExpr(String string, Boolean canClear) {
        if (!result.getText().toString().isEmpty()) {
            expr.setText("");
        }

        if (canClear) {
            result.setText("");
            expr.append(string);
        } else {
            expr.append(result.getText());
            expr.append(string);
            result.setText("");
        }
    }

}
