class ZookeepersController < ApplicationController
  load_and_authorize_resource :only => [:destroy, :long_running_queries], :shallow => true

  before_filter :set_zookeeper_with_preference, :only => :index
  before_filter :set_zookeeper_before_filter, :only => :show
  before_filter :current_zookeeper, :only => :show

  respond_to :html, :only => [:index, :show]
  respond_to :json

  def index
    set_zookeeper Zookeeper.first.id if Zookeeper.count == 1
    respond_with do |format|
      format.json { render :json => Zookeeper.dashboard_stats }
    end
  end

  def show
    respond_with(@current_zookeeper) do |format|
      format.json { render :json => @current_zookeeper, :methods => [:clusters, :blur_controllers] }
    end
  end

  def destroy
    @zookeeper.destroy
    Audit.log_event(current_user, "Zookeeper (#{@zookeeper.name}) was forgotten", "zookeeper", "delete") if @zookeeper.destroyed?
    respond_with(@zookeeper)
  end

  def long_running_queries
    respond_with(@zookeeper) do |format|
      format.json { render :json => @zookeeper.long_running_queries(current_user) }
    end
  end
end
