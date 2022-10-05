
     ****** Dimensions Scalable Android , for the Android Design guidelines. By CodingZip (Drex) ******

     -----------USES : -------------------------------------------------------------------
     copy all the generated folders (values-sw<N>dp) to the src/directory of your project
     if you did not choose it directly as the destination directory
     -------------------------------------------------------------------------------------

     these xml files contain positive values ​​ranging from 0 to 1000
     and negative from 0 to -1000 for each size in dp, sp and px

     and resize as follows for different screen formats:
	 
     --> (sw320dp) small 1*1.1 = 1.1 (values-sw320dp) > medium screen <medium phone> ~320-480 DP

     --> (sw480dp) normal 1*1.6 = 1.6 (values-sw480dp) > normal screen <large phone> ~480-600 DP
	
     --> (sw600dp) large 1*2 = 2 (values-sw600dp) > large screen <medium tablet> ~600-720 DP

     --> (sw720dp) xlarge 1*2.4 = 2.4 (values-xxhdpi) > xlarge screen <large tablet> ~720+ DP

    ----------- EXAMPLE OF USES : -----------

    ______for material design value : ______

    for values of material design use exemple -> @dimen/size_defaultText_dsa
    for values of material design use exemple -> @dimen/size_Button_Text_dsa

    ______for a positive value : ______

    for values in dp (50dp) use -> @dimen/dp_50_dsa
    for values in sp (50sp) use -> @dimen/sp_50_dsa
    for values in px (50px) use -> @dimen/px_50_dsa

    ______ for a negative value : ______

    for values in dp (-50dp) use -> @dimen/dp_50_minus_dsa
    for values in sp (-50sp) use -> @dimen/sp_50_minus_dsa
    for values in px (-50px) use -> @dimen/px_50_minus_dsa


    ______ example for textView size for material design : ______
    <TextView
        android:text="CodingZip"

        //title size for material design
        android:textSize="@dimen/size_Title_dsa"
		
		//Title spacing size for material design
		android:letterSpacing ="@dimen/size_Title_LetterSpacing_dsa"

        //in negative dp
        android:layout_height="@dimen/dp_40_minus_dsa"

        //in positive dp
        android:layout_width="@dimen/dp_43_dsa"
        android:layout_marginStart="@dimen/dp_2_dsa "
        android:layout_marginTop="@dimen/dp_4_dsa "/>


    ______ example for textView : ______
    <TextView
        android:text="CodingZip"

        //in positive sp
        android:textSize="@dimen/sp_50_dsa"
		
		//default letter Spacing size for material design
		android: letterSpacing ="@dimen/size_defaultText_LetterSpacing_dsa"

        //in negative dp
        android:layout_height="@dimen/dp_20_minus_dsa"

        //in positive dp
        android:layout_width="@dimen/dp_43_dsa"
        android:layout_marginStart="@dimen/dp_2_dsa "
        android:layout_marginTop="@dimen/dp_4_dsa "/>


    ______ example for LinearLayout : ______
    <LinearLayout
        android:orientation="vertical"

        //in positive dp
        android:layout_width="@dimen/dp_23_dsa"
        android:layout_height="@dimen/dp_50_dsa"

        //in negative dp
        android:layout_marginStart="@dimen/dp_50_minus_dsa"
        >
    </LinearLayout>
