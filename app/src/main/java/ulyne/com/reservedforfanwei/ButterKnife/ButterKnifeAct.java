package ulyne.com.reservedforfanwei.ButterKnife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ulyne.com.reservedforfanwei.R;

/**
 * Created by fanwei on 2017/4/5.
 */

public class ButterKnifeAct extends AppCompatActivity {
    @BindView(R.id.tv_1)
    TextView tv1;

    @BindView(R.id.btn_1)
    Button btn1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_1)
    void tv1OnClick(View view) {
        String content = ((TextView) view).getText().toString();
        Toast.makeText(ButterKnifeAct.this, "tv_1" + content, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_1)
    void btnOnClick() {
        Toast.makeText(ButterKnifeAct.this, "btn_1", Toast.LENGTH_SHORT).show();
    }
}
