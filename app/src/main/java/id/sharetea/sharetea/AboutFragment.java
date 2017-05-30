package id.sharetea.sharetea;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import id.sharetea.sharetea.AsyncTask.MyAsyncTask;
import id.sharetea.sharetea.app.AppConfig;
import id.sharetea.sharetea.app.HttpHandler;


public class AboutFragment extends Fragment {

    private WebView webView;
    TextView title;
    Toolbar toolbar;
    String webActionTitle;
    String web;
    ImageView back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myInflater =inflater.inflate(R.layout.fragment_web, container, false);
        webView = (WebView) myInflater.findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        new getWeb().execute();
        return myInflater;
    }

    private class getWeb extends MyAsyncTask {




        @Override
        public Context getContext() {
            return getActivity();
        }

        @Override
        public void setSuccessPostExecute() {
            webView.loadData(web, "text/html", "UTF-8");

        }

        @Override
        public void setFailPostExecute() {

        }

        @Override
        public void postData() {
            HttpHandler sh = new HttpHandler();
            String url = "http://www.sharetea.id/index.php/about-us/";


            try {
                web = sh.makeServiceCall(url);
                isSucces=true;
            } catch (IOException e) {
                badInternetAlert();
            }
        }
    }


}
