package nazar.optigra_vk_test;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

import java.util.ArrayList;
import java.util.TreeSet;

import nazar.optigra_vk_test.model.AndroidPost;
import nazar.optigra_vk_test.model.AvtorsList;
import nazar.optigra_vk_test.model.GroupWrapper;
import nazar.optigra_vk_test.model.WallVk;

public class Activity_request extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__wall);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }


        //startActivity(new Intent(this, MainActivity.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity__wall, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        VKRequest request;
        VKRequest request_id;
        VKRequest reguest_groups;

        VKRequest.VKRequestListener mRequestListener = new VKRequest.VKRequestListener()
        {
            @Override
            public void onComplete(VKResponse response)
            {
                Log.v("12345",response.json.toString());
                if (getView()!=null) {
                    String json=response.json.toString();
                    Gson gson=new Gson();
                    WallVk wallvk=gson.fromJson(json,WallVk.class);
                    ArrayList<AndroidPost> array_post=new ArrayList<AndroidPost>();
                    AndroidPost androidPost=null;
                    TreeSet<String> id_set=new TreeSet<String>();


                    for  (WallVk.responseVk.Post temp:wallvk.response.postlist){

                        androidPost=new AndroidPost(temp);

                        id_set.add(androidPost.getAvtor());
                        if (androidPost.getOther_avtor()!=null)
                            id_set.add(androidPost.getOther_avtor());
                        array_post.add(androidPost);
                    }


                    String  ids=id_set.toString().replace('[',' ').replace(']',' ').trim();



                    request_id=VKApi.users().get(VKParameters.from(VKApiConst.USER_IDS,ids,VKApiConst.FIELDS,
                            "id,first_name,last_name"));
                    request_id.registerObject();
                    if (request_id == null) return;
                    request_id.executeWithListener(mRequestListener_ids);
                    ArrayList<GroupWrapper> groups=new ArrayList<GroupWrapper>();
                    for (WallVk.responseVk.Group temp:wallvk.response.groups){
                        GroupWrapper asd=new GroupWrapper(temp);
                        groups.add(asd);
                        Log.v("12345",asd.name+"    "+asd.id);
                    }









                    Intent intent=getActivity().getIntent();
                    intent.putExtra("response", array_post);
                    intent.putExtra("groups",groups);




                    //intent.putExtra("groups",);


                    //for (Group temp:wallvk.response.groups){
                      //  Log.v("12345",temp.name.toString() +"    "+temp.id.toString());


                    //}





                    //Intent intent=new Intent(getActivity(), Vk_wall_activity.class);




                    //intent.putExtra("response", array_post);
                    //intent.putExtra("ids",id_set.toString().replace('[',' ').replace(']',' ').trim());
                    //intent.setClass(getActivity(), Vk_wall_activity.class);




                    //startActivity(intent);
                }

            }

            @Override
            public void onError(VKError error)
            {
               // setResponseText(error.toString());
            }

            @Override
            public void onProgress(VKRequest.VKProgressType progressType, long bytesLoaded,
                                   long bytesTotal)
            {
                // you can show progress of the request if you want
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts)
            {

            }
        };

        VKRequest.VKRequestListener mRequestListener_ids = new VKRequest.VKRequestListener() {

            @Override
            public void onComplete(VKResponse response)
            {

                String json=response.json.toString();
                Gson gson=new Gson();
                AvtorsList avtors=gson.fromJson(json,AvtorsList.class);
                Intent intent=new Intent(getActivity(), Vk_wall_activity.class);
                for (AvtorsList.Avtor temp:avtors.response){
                    intent.putExtra(temp.id,temp.first_name+"  "+temp.last_name);
                }



                intent.putExtra("response", getActivity().getIntent().getParcelableArrayListExtra("response"));
                ArrayList<GroupWrapper> groups=new ArrayList<GroupWrapper>();
                groups=getActivity().getIntent().getParcelableArrayListExtra("groups");


               for (GroupWrapper temp:groups){
                        intent.putExtra("-"+temp.id,temp.name);

               }




                startActivity(intent);
            }

            @Override
            public void onError(VKError error)
            {
               Log.v("12345",error.toString());
            }

            @Override
            public void onProgress(VKRequest.VKProgressType progressType, long bytesLoaded,
                                   long bytesTotal)
            {
                // you can show progress of the request if you want
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts)
            {

            }



        };


        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_activity__wall, container, false);
            request = VKApi.wall().get(VKParameters.from(VKApiConst.EXTENDED, 1,VKApiConst.OWNER_ID,"45264767",VKApiConst.COUNT,"99"));
            return rootView;
        }
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            TextView asd=(TextView)getView().findViewById(R.id.Result);
            request.registerObject();
            //request_id.registerObject();
            if (request == null) return;
           // if (request_id == null) return;

            request.executeWithListener(mRequestListener);
            //request.executeWithListener(mRequestListener_ids);
            //asd.setText(request.registerObject().);

        }
    }


}
