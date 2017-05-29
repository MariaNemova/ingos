package ru.ingos.digitalmedicine;

import android.app.Application;

/**
 * Класс создан для хранения статических данных, к которым должен быть организован доступ из всех частей проекта.
 */
public class IngosApplication extends Application{

    public final static String DEBUG_TAG = "MOJAR";

    public final static String EXTRA_FRAGMENT_CLASSNAME = "EXTRA_CLASSNAME";
    public final static String EXTRA_CLINIC_NAME = "CLINIC_NAME";
    public final static String EXTRA_DOCTOR_ID = "EXTRA_DOCTOR_ID";
    public final static String EXTRA_IS_CONFIRMATION = "IS_CONFIRMATION";
    public final static String EXTRA_IS_FROM_BRGINING = "FROM_BEGINIG";
    public final static String EXTRA_ID_FOR_FRAGMENT = "ID_FOR_FRAGMENT";

}
