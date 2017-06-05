package main.mobileguard.com.project_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dom.mpresenter.UserPresenter;
import com.dom.mview.IUserView;

public class MainActivity extends AppCompatActivity implements IUserView,View.OnClickListener{
private EditText editId,editName,editAge;
    private UserPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editId = (EditText)findViewById(R.id.userID);
        editName=(EditText)findViewById(R.id.userName);
        editAge = (EditText)findViewById(R.id.userAge);
        ((Button)findViewById(R.id.save)).setOnClickListener(this);
        ((Button)findViewById(R.id.load)).setOnClickListener(this);
        presenter = new UserPresenter(this);
    }

    @Override
    public String getID() {
        return editId.getText().toString().trim();
    }

    @Override
    public void setID(String ID) {

    }

    @Override
    public String getUserName() {
        return editName.getText().toString().trim();
    }

    @Override
    public void setUserName(String userName) {
    editName.setText(userName);
    }

    @Override
    public int getAge() {
        return Integer.parseInt(editAge.getText().toString().trim());
    }

    @Override
    public void setAge(int age) {
        editAge.setText(age+"");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save:
           Boolean tag =  presenter.saveUser(getID(),getUserName(),getAge());
                if (tag){
                Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"保存失败",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.load:
                presenter.loadUser(getID());
                break;
            default:
                break;
        }
    }
}
