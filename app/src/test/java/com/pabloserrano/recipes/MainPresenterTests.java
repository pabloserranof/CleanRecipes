package com.pabloserrano.recipes;

import com.pabloserrano.recipes.data.RecipesRepositoryImpl;
import com.pabloserrano.recipes.presenter.MainPresenterImp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainPresenterTests {

    @Mock
    RecipesRepositoryImpl mockRepository;

    MainPresenterImp presenter;


}