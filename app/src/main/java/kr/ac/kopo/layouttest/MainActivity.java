package kr.ac.kopo.layouttest;

import android.graphics.Color; // 주석 코드에서 사용되는 Color 클래스
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup; // 주석 코드에서 사용되는 ViewGroup 클래스
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // 1. 위젯 변수 선언
    LinearLayout linearRed, linearBlue;
    Button btnRed, btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.actuvity_main12);

        // 상단 상태바 및 하단 네비게이션 바 영역 조정 (WindowInsets)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main12), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 2. XML의 ID와 Java 변수 연결 (findViewById)
        linearRed = findViewById(R.id.linear_red);
        linearBlue = findViewById(R.id.linear_blue);
        btnRed = findViewById(R.id.btn_red);
        btnBlue = findViewById(R.id.btn_blue);

        // 3. 버튼에 리스너 연결
        btnRed.setOnClickListener(btnListener);
        btnBlue.setOnClickListener(btnListener);

        /*
         * [참고] 아래는 코드로 직접 레이아웃을 생성하는 예시입니다. (필요시 주석 해제)
         * * LinearLayout linear = new LinearLayout(this);
         * LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
         * ViewGroup.LayoutParams.MATCH_PARENT,
         * ViewGroup.LayoutParams.MATCH_PARENT);
         * linear.setOrientation(LinearLayout.VERTICAL);
         * linear.setBackgroundColor(Color.GREEN);
         * * Button btn = new Button(this);
         * btn.setText("코드로 작성한 버튼");
         * btn.setBackgroundColor(Color.MAGENTA);
         * linear.addView(btn);
         * * btn.setOnClickListener(new View.OnClickListener() {
         * @Override
         * public void onClick(View v) {
         * Toast.makeText(getApplicationContext(), "코드로 작성한 버튼 클릭!", Toast.LENGTH_SHORT).show();
         * }
         * });
         * * // 이 명령을 실행하면 activity_main12.xml 대신 코드로 만든 linear 레이아웃이 화면을 덮습니다.
         * // setContentView(linear, params);
         */
    }

    // 4. 공통 클릭 리스너 정의
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 먼저 모든 레이아웃을 숨깁니다.
            linearRed.setVisibility(View.INVISIBLE);
            linearBlue.setVisibility(View.INVISIBLE);

            // 클릭된 버튼에 따라 특정 레이아웃만 보여줍니다.
            if (v.getId() == R.id.btn_red) {
                linearRed.setVisibility(View.VISIBLE);
            } else if (v.getId() == R.id.btn_blue) {
                linearBlue.setVisibility(View.VISIBLE);
            }
        }
    };
}