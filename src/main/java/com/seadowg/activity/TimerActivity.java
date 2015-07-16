package com.seadowg.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.seadowg.R;

public class TimerActivity extends AppCompatActivity implements View.OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.timer);

    findViewById(R.id.start_button).setOnClickListener(this);
    findViewById(R.id.reset_button).setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.start_button:
        onSubmitWeight();
        break;
      case R.id.reset_button:
        onReset();
        break;
      default:
        break;
    }
  }

  private void onSubmitWeight() {
    try {
      Integer weight = Integer.parseInt(((TextView) findViewById(R.id.weight)).getText().toString());
      Integer totalMinsToCook = Math.round((weight / 500f) * 25f) + 25;
      Integer hoursToCook = totalMinsToCook / 60;
      Integer minsToCook = totalMinsToCook % 60;

      TextView remaining = (TextView) findViewById(R.id.remaining);
      remaining.setText(hoursToCook + ":" + minsToCook);

      findViewById(R.id.running).setVisibility(View.VISIBLE);
      findViewById(R.id.not_running).setVisibility(View.GONE);
    } catch (NumberFormatException e) {
      AlertDialog error = new AlertDialog.Builder(this)
              .setMessage(getString(R.string.no_weight_error))
              .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  dialogInterface.dismiss();
                }
              }).create();

      error.show();
    }
  }

  private void onReset() {
    findViewById(R.id.running).setVisibility(View.GONE);
    findViewById(R.id.not_running).setVisibility(View.VISIBLE);
  }
}
