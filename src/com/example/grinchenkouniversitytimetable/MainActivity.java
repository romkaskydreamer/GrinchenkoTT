package com.example.grinchenkouniversitytimetable;

import java.io.InputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String dayOfWeek;
	private int todayDayNumber;
	private String[] drawerListViewItems;
	private DrawerLayout drawerLayout;
	private ListView drawerListView;
    private EditText  username=null;
    private EditText  password=null;
    private TextView attempts;
    private Button login;
    int counter = 3;
    int success;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	loginpas();
		setContentView(R.layout.activity_main);
		success=1;
		if(success==1){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			Calendar now = Calendar.getInstance();
		// drAWER navigation start
		// get list items from strings.xml
		drawerListViewItems = getResources().getStringArray(R.array.items);
//		// get ListView defined in activity_main.xml
		drawerListView = (ListView) findViewById(R.id.left_drawer);
//		// Set the adapter for the list view
		drawerListView.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_listview_item, drawerListViewItems));
		drawerListView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						Toast.makeText(MainActivity.this, "You pressed me!",
								Toast.LENGTH_SHORT).show();
					}
				});
		// drawer navigation end

		todayDayNumber = now.get(Calendar.DAY_OF_WEEK);
		switcher();}
	}

	private void switcher() {
		TextView day = (TextView) findViewById(R.id.textView1);
		TextView lecture1 = (TextView) findViewById(R.id.textView2);
		TextView lecture2 = (TextView) findViewById(R.id.textView3);
		TextView lecture3 = (TextView) findViewById(R.id.textView4);
		TextView lecture1time = (TextView) findViewById(R.id.textView5);
		TextView lecture2time = (TextView) findViewById(R.id.textView6);
		TextView lecture3time = (TextView) findViewById(R.id.textView7);
		try {
			// InputStream myInput;
			InputStream myInput = this.getAssets().open("file.xls"); 
			// myInput = assetManager.open("song");
			if (myInput != null)
				Log.e("input", "It worked!");

			// Create a POIFSFileSystem object
			POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

			// // Create a workbook using the File System
			HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
			switch (todayDayNumber) {
			case 2:
				dayOfWeek=("Понеділок");
				HSSFSheet mondaySheet = myWorkBook.getSheetAt(0);
				lecture1.setText(mondaySheet.getRow(1).getCell(2).toString());
				lecture2.setText(mondaySheet.getRow(2).getCell(2).toString());
				lecture3.setText(mondaySheet.getRow(3).getCell(2).toString());
				lecture1time.setText(mondaySheet.getRow(1).getCell(1)
						.toString());
				lecture2time.setText(mondaySheet.getRow(2).getCell(1)
						.toString());
				lecture3time.setText(mondaySheet.getRow(3).getCell(1)
						.toString());
				break;
			case 3:
				dayOfWeek=("Вівторок");
				HSSFSheet tuesdaySheet = myWorkBook.getSheetAt(1);
				lecture1.setText(tuesdaySheet.getRow(1).getCell(2).toString());
				lecture2.setText(tuesdaySheet.getRow(2).getCell(2).toString());
				lecture3.setText(tuesdaySheet.getRow(3).getCell(2).toString());
				lecture1time.setText(tuesdaySheet.getRow(1).getCell(1)
						.toString());
				lecture2time.setText(tuesdaySheet.getRow(2).getCell(1)
						.toString());
				lecture3time.setText(tuesdaySheet.getRow(3).getCell(1)
						.toString());
				break;
			case 4:
				dayOfWeek=("Середа");
				HSSFSheet wednesdaySheet = myWorkBook.getSheetAt(2);
				lecture1.setText(wednesdaySheet.getRow(1).getCell(2).toString());
				lecture2.setText(wednesdaySheet.getRow(2).getCell(2).toString());
				lecture3.setText(wednesdaySheet.getRow(3).getCell(2).toString());
				lecture1time.setText(wednesdaySheet.getRow(1).getCell(1)
						.toString());
				lecture2time.setText(wednesdaySheet.getRow(2).getCell(1)
						.toString());
				lecture3time.setText(wednesdaySheet.getRow(3).getCell(1)
						.toString());
				break;
			case 5:
				dayOfWeek=("Четвер");
				HSSFSheet thursdaySheet = myWorkBook.getSheetAt(3);
				lecture1.setText(thursdaySheet.getRow(1).getCell(2).toString());
				lecture2.setText(thursdaySheet.getRow(2).getCell(2).toString());
				lecture3.setText(thursdaySheet.getRow(3).getCell(2).toString());
				lecture1time.setText(thursdaySheet.getRow(1).getCell(1)
						.toString());
				lecture2time.setText(thursdaySheet.getRow(2).getCell(1)
						.toString());
				lecture3time.setText(thursdaySheet.getRow(3).getCell(1)
						.toString());
				break;
			case 6:
				dayOfWeek=("П'ятниця");
				HSSFSheet fridaySheet = myWorkBook.getSheetAt(4);
				lecture1.setText(fridaySheet.getRow(1).getCell(2).toString());
				lecture2.setText(fridaySheet.getRow(2).getCell(2).toString());
				lecture3.setText(fridaySheet.getRow(3).getCell(2).toString());
				lecture1time.setText(fridaySheet.getRow(1).getCell(1)
						.toString());
				lecture2time.setText(fridaySheet.getRow(2).getCell(1)
						.toString());
				lecture3time.setText(fridaySheet.getRow(3).getCell(1)
						.toString());
				break;
			case 7:
				dayOfWeek=("Субота");
				lecture1.setText("-");
				lecture2.setText("-");
				lecture3.setText("-");
				lecture1time.setText("-");
				lecture2time.setText("-");
				lecture3time.setText("-");
				break;
			case 1:
				dayOfWeek=("Неділя");
				lecture1.setText("-");
				lecture2.setText("-");
				lecture3.setText("-");
				lecture1time.setText("-");
				lecture2time.setText("-");
				lecture3time.setText("-");
				break;
			default:
				dayOfWeek = ("Понеділок");
				break;
			}
			day.setText(dayOfWeek);
			Log.e("successreadexcel", "success??");
		} catch (Exception e) {
			e.printStackTrace();
			Log.e("failedreadexcel", "shit");
		}
	}
	private void loginpas(){
		setContentView(R.layout.login);
		 username = (EditText)findViewById(R.id.editText1);
	        password = (EditText)findViewById(R.id.editText2);
	        attempts = (TextView)findViewById(R.id.textView5);
	        attempts.setText(Integer.toString(counter));
	        login = (Button)findViewById(R.id.button1);
	}
	
    public void login(View view){
        if(username.getText().toString().equals("admin") && 
        password.getText().toString().equals("admin")){
        Toast.makeText(getApplicationContext(), "Redirecting to app", 
        Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        success=1;
        Calendar now = Calendar.getInstance();
        todayDayNumber = now.get(Calendar.DAY_OF_WEEK);
		switcher();
     }	
     else{
        Toast.makeText(getApplicationContext(), "Wrong Credentials",
        Toast.LENGTH_SHORT).show();
        attempts.setBackgroundColor(Color.RED);	
        counter--;
        attempts.setText(Integer.toString(counter));
        if(counter==0){
           login.setEnabled(false);
        }
     }
    }
	public void clickOnPrevButton(View v) {
		todayDayNumber = todayDayNumber - 1;
		switcher();

	//	 Toast.makeText(this, "todaydaynumber=" + getLa,
		// Toast.LENGTH_SHORT).show();
	}

	public void clickOnNextButton(View v) {
		todayDayNumber = todayDayNumber + 1;
		switcher();
		// Toast.makeText(this, "todaydaynumber=" + todayDayNumber,
		// Toast.LENGTH_SHORT).show();
	}

}