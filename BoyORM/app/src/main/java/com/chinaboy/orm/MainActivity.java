package com.chinaboy.orm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.chinaboy.orm.db.BaseModel;
import com.chinaboy.orm.db.DBOperateAsyncListener;
import com.chinaboy.orm.db.DatabaseManager;
import com.chinaboy.orm.db.DatabaseOptionType;
import com.chinaboy.orm.model.Teacher;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.button)
    public void addData() {
        Teacher teacher = new Teacher();
        teacher.name = "mm";
        DatabaseManager.getInstance().insert(Teacher.class, teacher, new DBOperateAsyncListener() {
            @Override
            public <T extends BaseModel> void onPostExecute(DatabaseOptionType optionType, Class<T> claz,
                                                            List<T> successModels, List<T> failModels) {
                if (successModels != null) {
                    Log.i("Code", "Success = " + successModels.get(0).toString());
                } else if (failModels != null) {
                    Log.i("Code", "Fail = " + failModels.get(0).toString());
                }
            }
        });

    }
}
