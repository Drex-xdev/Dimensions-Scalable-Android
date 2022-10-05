
     ****** Dimensions Scalable Android , pour les lignes directrices de conception Android. Par: CodingZip (Drex) ******

     -----------UTILISATION: -----------------------------------------------------------------
     copier tous les dossiers générer (values-sw<N>dp) dans le répertoire src/de votre projet
     si vous ne l’avez pas choisi directement comme répertoire de destination
     ------------------------------------------------------------------------------------------

     ces fichiers xml contiennent des valeurs positives allant de 0 à 1000
     et négatif de 0 à -1000 pour chaque taille en dp, sp et px

     et redimensionner comme suit pour différents formats d’écran :
	 
     --> (sw320dp) small 1*1.1 = 1.1 (values-sw320dp) > écran moyen <téléphone moyen > ~320-480 DP

     --> (sw480dp) normal 1*1.6 = 1.6 (values-sw480dp) > écran normal <téléphone large> ~480-600 DP
	
     --> (sw600dp) large 1*2 = 2 (values-sw600dp) > écran large <tablet moyen> ~600-720 DP

     --> (sw720dp) xlarge 1*2.4 = 2.4 (values-xxhdpi) > xlarge écran <tablet large> ~720+ DP

    ----------- EXAMPLE D'UTILISATION : -----------

    ______for material design value : ______

    pour les valeurs de conception material design utiliser par exemple  -> @dimen/size_defaultText_dsa
    pour les valeurs de conception material design utiliser par exemple -> @dimen/size_Button_Text_dsa

    ______ pour les valeurs positive : ______

    pour les valeurs en dp (50dp) use -> @dimen/dp_50_dsa
    pour les valeurs en sp (50sp) use -> @dimen/sp_50_dsa
    pour les valeurs en px (50px) use -> @dimen/px_50_dsa

    ______ pour les valeurs négative : ______

    pour les valeurs en dp (-50dp) use -> @dimen/dp_50_minus_dsa
    pour les valeurs en sp (-50sp) use -> @dimen/sp_50_minus_dsa
    pour les valeurs en px (-50px) use -> @dimen/px_50_minus_dsa


    ______ exemple pour la taille d'un textView pour material design : ______
    <TextView
        android:text="CodingZip"

        //taille d'un titre pour la conception en matériel design
        android:textSize="@dimen/size_Title_dsa"
		
		//Taille d’espacement des lettre d'un titre pour la conception en matériel design 
		android:letterSpacing ="@dimen/size_Title_LetterSpacing_dsa"

        //en dp négative
        android:layout_height="@dimen/dp_40_minus_dsa"

        //en dp positive
        android:layout_width="@dimen/dp_43_dsa"
        android:layout_marginStart="@dimen/dp_2_dsa "
        android:layout_marginTop="@dimen/dp_4_dsa "/>


    ______ autre exemple pour la taille d'un textView pour un material design  : ______
    <TextView
        android:text="CodingZip"

        //en sp positive 
        android:textSize="@dimen/sp_50_dsa"
		
		//Taille d’espacement par défaut pour la conception en matériel design 
		android: letterSpacing ="@dimen/size_defaultText_LetterSpacing_dsa"

        //en dp négative
        android:layout_height="@dimen/dp_20_minus_dsa"

        //en dp positive 
        android:layout_width="@dimen/dp_43_dsa"
        android:layout_marginStart="@dimen/dp_2_dsa "
        android:layout_marginTop="@dimen/dp_4_dsa "/>


    ______ exemple pour un LinearLayout : ______
    <LinearLayout
        android:orientation="vertical"

        //en dp positive 
        android:layout_width="@dimen/dp_23_dsa"
        android:layout_height="@dimen/dp_50_dsa"

        //en dp négative
        android:layout_marginStart="@dimen/dp_50_minus_dsa"
        >
    </LinearLayout>
