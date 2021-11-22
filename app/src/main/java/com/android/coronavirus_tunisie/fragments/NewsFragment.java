package com.android.coronavirus_tunisie.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.android.coronavirus_tunisie.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    ListView listView;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, container, false);
        // Inflate the layout for this fragment
        String[] menuItems={
                "Le ministère de la Santé a annoncé que 9 760 917 personnes ont reçu au moins une dose, depuis le démarrage de la campagne nationale de vaccination contre le coronavirus en mars dernier jusqu’au 11 novembre. nasale. Le résultat est en général disponible 24 heures après"
                ,"Le pass sanitaire est un document officiel attestant qu'une personne a achevé son schéma vaccinal contre le coronavirus."
                ,"La Tunisie enregistre ce samedi 13 novembre 2021 0 nouveaux cas de contamination soit  715.637 cas confirmés au total. Le pays comptabilise 25.308 décès au total dont 0 depuis le dernier bilan. En date du dimanche 14 novembre 2021, 4.773.511 personnes sont totalement vaccinées."
                ,"28 septembre 2021 : communiqué de presse :Comment la crise du Covid-19 a aggravé les écarts de réussite scolaire \".",
                "Le monde entier fait face à une crise sanitaire sans précédent due à la pandémie de Covid-19. On dénombre plus de 253.222.306 cas de coronavirus à travers le monde et 5.118.956 décès. Découvrez le bilan des pays et l'évolution dans le monde concernant l'épidémie de coronavirus ce lundi 15 novembre 2021.",
                "Vous avez un pouvoir immense : celui de sauver des dizaines de vies, en quelques minutes, grâce à un geste simple ! Ce week-end, rendez-vous dans l’établissement le plus proche pour faire don de votre sang "
                ,"Hopla, nouvelle journée, nouvelle garde de 24 heures aux urgences puis au SAMU. L’activité a repris comme avant #COVID19 ! Alors un petit café pour se donner du courage. Faites attention à vous qu’on ne vienne pas vous chercher ! Bon week-end à tous Visage rigolard avec des yeux rieurs",
                "Pour la troisième semaine consécutive, le continent européen a enregistré une augmentation du nombre de nouveaux cas hebdomadaires de Covid-19, avec plus de 1,3 million de nouveaux cas signalés, soit une hausse de 7% par rapport à la semaine précédente, a annoncé mercredi l’Organisation mondiale de la santé (OMS).",
                "Les derniers chiffres communiqués par Santé publique France ce lundi 15 novembre sont particulièrement inquiétants. Si 3 214 cas supplémentaires ont été enregistrés, soit 9 255 de moins que la veille, c'est tout de même 1 044 personnes de plus que lundi dernier."
        };


        listView= view.findViewById(R.id.list1);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );

        listView.setAdapter(listViewAdapter);
        return view;

    }


}
