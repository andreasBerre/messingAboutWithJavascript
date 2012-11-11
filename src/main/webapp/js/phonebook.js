(function ($) {

    var Entry = Backbone.Model.extend({
        defaults: function() {
            return {
                name: "Ny kontakt",
                phoneNumber: ""
            };
        }
    });

    var PhoneBook = Backbone.Collection.extend({
        model: Entry
    });

    var EntryView = Backbone.View.extend({
        tagName: "article",
        className: "entry-container",
        template: $("#entryTemplate").html(),
        render: function () {
            var tmpl = _.template(this.template);
            this.$el.html(tmpl(this.model.toJSON()));
            return this;
        }
    });

    var PhoneBookView = Backbone.View.extend({
        el: $("#entries"),
        initialize: function () {
            var that = this;
            $.get('service/phonebook/getEntries').then(function(entries){
                that.collection = new PhoneBook(entries);
                that.render();
            });
        },
        render: function () {
            var that = this;
            _.each(this.collection.models, function (item) {
                that.renderEntry(item);
            }, this);
        },
        renderEntry: function (item) {
            var entryView = new EntryView({
                model: item
            });
            this.$el.append(entryView.render().el);
        }
    });

    var phoneBook = new PhoneBookView();
} (jQuery));

