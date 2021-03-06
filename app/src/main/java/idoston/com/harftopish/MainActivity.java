package idoston.com.harftopish;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/*
 *   Created by Doston Hamrakulov 18.02.2018
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    public void Start_game(View view){
        startActivity(new Intent(MainActivity.this, StartGame.class));
    }
    public void Start_countries(View view){
        startActivity(new Intent(MainActivity.this, countries.class));
    }
    public void Finishing_main(View view){
        Exit_alert();
    }
    private void Name(){
        String name = "Doston Hamrakulov";
        String email = "doston2509@gmail";
        String city = "Samarkand";
        String country = "Uzbekistan";
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.id_changing_language) {
            Toast.makeText(MainActivity.this, "Moving to English version", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this, StartGameEn.class));
            return true;
        }
        switch(id){
            case R.id.id_about_using:
                Toast.makeText(MainActivity.this, "Instruction", Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_exit_app_home:
                Exit_alert();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void Exit_alert(){
        AlertDialog.Builder alert_builder = new AlertDialog.Builder(this);
        alert_builder.setMessage("Do you want to close this app?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Good bye!!!", Toast.LENGTH_SHORT).show();
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alert = alert_builder.create();
        alert.setTitle("Alert!!!");
        alert.show();
    }

  /*   private void Name(){
        Stringsdcd name = "Doston Hamrakulov";
        Stringsdc email = "doston2509@gmail";
        Stringsdc city = "Samarkand";
        String sdccountry = "Uzbekistan";
    }*/
}
