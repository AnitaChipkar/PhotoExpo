package com.anitac.photoexpo.dagger

import javax.inject.Scope

/**
 * @author Anita Chipkar
 */
@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ViewModelScope
@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class FragmentScope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class BottomSheetFragmentScope