import { createRouter, createWebHashHistory } from 'vue-router'
import HomePageIndex from '../pages/HomePage/index.vue'
import HomeView from '../pages/HomePage/HomeView.vue'
import ForumPageIndex from '../pages/ForumPage/index.vue'

import History from '../pages/HomePage/Introduction/History.vue'
import Artist from '../pages/HomePage/Introduction/Artist.vue'
import ArtistIndex from '../pages/HomePage/Introduction/Artist/index.vue'
import DuanYunli from '../pages/HomePage/Introduction/Artist/DuanYunli.vue'
import FuZuoren from '../pages/HomePage/Introduction/Artist/FuZuoren.vue'
import ChenFenwan from '../pages/HomePage/Introduction/Artist/ChenFenwan.vue'
import GuPengquan from '../pages/HomePage/Introduction/Artist/GuPengquan.vue'
import ManageContent from '../pages/UserPage/ManageContent.vue'
import Course from '../pages/HomePage/Introduction/Course.vue'
import Tech from '../pages/HomePage/Introduction/Tech.vue'
import folding from '../pages/HomePage/Introduction/Course/folding.vue'
import patterns from '../pages/HomePage/Introduction/Course/patterns.vue'
import GarlandPage from '../pages/HomePage/Introduction/Tech/GarlandPage.vue'
import IntaGlioPage from '../pages/HomePage/Introduction/Tech/IntaGlioPage.vue'
import stereoscopicPage from '../pages/HomePage/Introduction/Tech/stereoscopicPage.vue'
import ColoursPage from '../pages/HomePage/Introduction/Tech/ColoursPage.vue'

import Works from '../pages/HomePage/Introduction/Works.vue'

import ArticlePage from '../pages/ForumPage/ArticlePage.vue'
import ForumPageHome from '../pages/ForumPage/ForumPageHome.vue'

import ColumnIndex from '../pages/ColumnPage/index.vue'
import ColumnList from '../pages/ColumnPage/ColumnList.vue'
import ColumnHome from '../pages/ColumnPage/ColumnHome.vue'
import ColumnArticlePage from '../pages/ColumnPage/ColumnArticlePage.vue'
import ColumnUserPage from '../pages/ColumnPage/ColumnUserPage.vue'
import EditColumnArticle from '../pages/ColumnPage/EditColumnArticle.vue'

import UserPageIndex from '../pages/UserPage/index.vue'
import UserHomePage from '../pages/UserPage/UserHomePage.vue'
import PaperWorkIndex from '../pages/PaperworkPage/index.vue'
import PaperWorkView from '../pages/PaperworkPage/PaperworkView.vue'
import AllPaperWork from '../pages/PaperworkPage/AllPaperwork.vue'
const routes = [
	{
		path: '/',
		component: HomePageIndex,
		children: [
			{
				path: 'homeView',
				component: HomeView,
			},
			{
				path: 'history',
				component: History,
			},
			{
				path: 'artist',
				component: ArtistIndex,
				children: [
					{
						path: 'artistview',
						component: Artist,
					},
					{
						path: 'duanyunli',
						component: DuanYunli,
					},
					{
						path: 'fuzuoren',
						component: FuZuoren,
					},
					{
						path: 'chenfenwan',
						component: ChenFenwan,
					},
					{
						path: 'gupengquan',
						component: GuPengquan,
					},
				],
				redirect: '/artist/artistview',
			},
			{
				path: 'course',
				component: HomePageIndex,
				children: [
					{
						path: 'courseView',
						component: Course,
					},
					{
						path: 'folding',
						component: folding,
					},
					{
						path: 'patterns',
						component: patterns,
					},
				],
				redirect: '/course/courseView',
			},
			{
				path: 'tech',
				component: HomePageIndex,
				children: [
					{
						path: 'techView',
						component: Tech,
					},
					{
						path: 'garland',
						component: GarlandPage,
					},
					{
						path: 'intaglio',
						component: IntaGlioPage,
					},
					{
						path: 'stereoscopic',
						component: stereoscopicPage,
					},
					{
						path: 'colours',
						component: ColoursPage,
					},
				],
				redirect: '/tech/techView',
			},
			{
				path: 'works',
				component: Works,
			},
		],
		redirect: '/homeView',
	},
	{
		path: '/user',
		component: UserPageIndex,
		children: [
			{
				path: 'userhome',
				component: UserHomePage,
			},
			{
				path: 'managecontent',
				component: ManageContent,
			},
		],

		redirect: '/user/userhome',
	},
	{
		path: '/forum',
		component: ForumPageIndex,
		children: [
			{
				path: 'forumPageHome',
				component: ForumPageHome,
			},
			{
				path: 'articlePage/:id',
				component: ArticlePage,
			},
		],
		redirect: '/forum/forumPageHome',
	},
	{
		path: '/column',
		component: ColumnIndex,
		children: [
			{
				path: 'columnHome/:id',
				component: ColumnHome,
			},
			{
				path: 'columnList',
				component: ColumnList,
			},
			{
				path: 'columnArticlePage/:id',
				component: ColumnArticlePage,
			},
			{
				path: 'columnUserPage/:id',
				component: ColumnUserPage,
			},
			{
				path: 'editArticle/:id',
				component: EditColumnArticle,
			},
		],
		redirect: '/column/columnList',
	},
	{
		path: '/paperwork',
		component: PaperWorkIndex,
        children: [
            {
                path: 'allpaperwork',
                component: AllPaperWork,
            },
        ],
        redirect: '/paperwork/allpaperwork',
	},
	{
		path: '/paperworkview/:id',
		component: PaperWorkView,
	},
	{
		path: '/histories',
		component: History,
	},
	{
		path: '/artists',
		component: Artist,
	},
	{
		path: '/techs',
		component: Tech,
	},
]

const router = createRouter({
	history: createWebHashHistory(),
	routes,
})
export default router
