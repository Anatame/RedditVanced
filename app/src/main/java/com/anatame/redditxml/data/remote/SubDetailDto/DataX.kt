package com.anatame.redditred.data.remote.SubDetailDto

import com.anatame.redditxml.data.remote.SubDetailDto.SubRedditDetail

data class DataX(
    val accept_followers: Boolean,
    val accounts_active: Int,
    val accounts_active_is_fuzzed: Boolean,
    val active_user_count: Int,
    val advertiser_category: String,
    val all_original_content: Boolean,
    val allow_discovery: Boolean,
    val allow_images: Boolean,
    val allow_polls: Boolean,
    val allow_prediction_contributors: Boolean,
    val allow_predictions: Boolean,
    val allow_predictions_tournament: Boolean,
    val allow_videogifs: Boolean,
    val allow_videos: Boolean,
    val banner_background_color: String,
    val banner_background_image: String,
    val banner_img: String,
    val banner_size: List<Any>,
    val can_assign_link_flair: Boolean,
    val can_assign_user_flair: Boolean,
    val collapse_deleted_comments: Boolean,
    val comment_score_hide_mins: Int,
    val community_icon: String,
    val community_reviewed: Boolean,
    val created: Int,
    val created_utc: Int,
    val description: String,
    val description_html: String,
    val disable_contributor_requests: Boolean,
    val display_name_prefixed: String,
    val emojis_custom_size: Any,
    val emojis_enabled: Boolean,
    val has_menu_widget: Boolean,
    val header_size: List<Any>,
    val header_title: String,
    val hide_ads: Boolean,
    val icon_img: String,
    val id: String,
    val is_crosspostable_subreddit: Boolean,
    val is_enrolled_in_new_modmail: Any,
    val key_color: String,
    val lang: String,
    val link_flair_enabled: Boolean,
    val link_flair_position: String,
    val mobile_banner_image: String,
    val name: String,
    val notification_level: Any,
    val original_content_tag_enabled: Boolean,
    val over18: Boolean,
    val prediction_leaderboard_entry_type: String,
    val primary_color: String,
    val public_description: String,
    val public_description_html: String,
    val public_traffic: Boolean,
    val quarantine: Boolean,
    val restrict_commenting: Boolean,
    val should_archive_posts: Boolean,
    val show_media: Boolean,
    val show_media_preview: Boolean,
    val spoilers_enabled: Boolean,
    val submission_type: String,
    val submit_link_label: String,
    val submit_text: String,
    val submit_text_label: String,
    val subreddit_type: String,
    val subscribers: Int,
    val suggested_comment_sort: Any,
    val url: String,
    val user_flair_css_class: Any,
    val user_flair_enabled_in_sr: Boolean,
    val user_flair_position: String,
    val user_flair_richtext: List<Any>,
    val user_flair_template_id: Any,
    val user_flair_text: Any,
    val user_flair_text_color: Any,
    val user_flair_type: String,
    val user_has_favorited: Any,
    val user_is_contributor: Any,
    val user_is_moderator: Any,
    val user_is_subscriber: Any,
    val user_sr_flair_enabled: Any,
    val user_sr_theme_enabled: Boolean,
    val whitelist_status: String,
    val wls: Int
)

fun DataX.toSubRedditDetail(): SubRedditDetail {
    return SubRedditDetail(
        icon_img = icon_img
    )
}