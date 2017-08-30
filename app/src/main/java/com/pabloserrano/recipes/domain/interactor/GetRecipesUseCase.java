/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pabloserrano.recipes.domain.interactor;

import com.google.common.base.Preconditions;
import com.pabloserrano.recipes.data.RecipesRepository;
import com.pabloserrano.recipes.data.model.RecipeList;
import com.pabloserrano.recipes.domain.executor.PostExecutionThread;
import com.pabloserrano.recipes.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving data related to an specific {@link com.pabloserrano.recipes.data.model.RecipeList}.
 */
public class GetRecipesUseCase extends UseCase<RecipeList, GetRecipesUseCase.Params> {

  private final RecipesRepository recipesRepository;

  @Inject
  GetRecipesUseCase(RecipesRepository recipesRepository, ThreadExecutor threadExecutor,
                    PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.recipesRepository = recipesRepository;
  }

  @Override Observable<RecipeList> buildUseCaseObservable(Params params) {
    Preconditions.checkNotNull(params);
    return this.recipesRepository.getRecipes(params.keyword);
  }

  public static final class Params {

    private final String keyword;

    private Params(String keyword) {
      this.keyword = keyword;
    }

    public static Params forKeyword(String keyword) {
      return new Params(keyword);
    }
  }
}
