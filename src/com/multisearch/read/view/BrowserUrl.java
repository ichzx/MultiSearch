package com.multisearch.read.view;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowserUrl {
    public void browserUrl(String url){
        if (Desktop.isDesktopSupported()){
            try {
                URI uri = new URI(url);
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(uri);
            }catch (URISyntaxException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        BrowserUrl browserUrl = new BrowserUrl();
        String url = SearchView.url;
        browserUrl.browserUrl(url);
    }
}
