package test.com.livetest;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lib.QRCodeUtil.QRCodeUtil;

public class QrcodeActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEditText;
    private Button mQrcodeBtn;
    private ImageView mImgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        mQrcodeBtn = (Button) findViewById(R.id.qrcode_btn);
        mImgView = (ImageView)findViewById(R.id.img_view);
        mEditText = (EditText)findViewById(R.id.url_edit);
        mQrcodeBtn.setOnClickListener(this);
        /*mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i("Ansen","内容改变之前调用:"+s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("Ansen","内容改变，可以去告诉服务器:"+s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("Ansen","内容改变之后调用:"+s);
            }*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qrcode_btn:
               // String str = "http://www.baidu.com";
                String str = mEditText.getText().toString();
                mImgView.setImageBitmap(QRCodeUtil.createQRCodeBitmap(str, 400));
                break;
        }
    }


}
