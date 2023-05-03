package com.app.loc.dagger

import javax.inject.Scope

/**
 * @author Anita Chipkar
 * @since 13/06/2022
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